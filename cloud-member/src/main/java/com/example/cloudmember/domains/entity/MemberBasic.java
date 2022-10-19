package com.example.cloudmember.domains.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Embeddable
@ToString(of = {"username", "disabled"})
@EqualsAndHashCode(of = {"username", "disabled"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberBasic {
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "disabled", nullable = false)
    private boolean disabled;

    // -- 내부 비즈니스 로직 -- //
    public void updateUsername(String username) {
        this.username = username;
    }

    /**
     * 계정 만료, 탈퇴시 경우 사용
     */
    public void disable() {
        this.disabled = true;
    }

    /**
     * 계정 활성화시 사용
     */
    public void activate() {
        this.disabled = false;
    }

    /**
     * 계정 활성화 상태 체크
     * @return boolean
     */
    public boolean isDisabled() {
        return this.disabled;
    }

    // -- 내부 생성자 메서드 -- //
    public static MemberBasic create(
        String username,
        boolean disabled
    ) {
        return MemberBasic.builder()
            .username(username)
            .disabled(disabled)
            .build();
    }
}
