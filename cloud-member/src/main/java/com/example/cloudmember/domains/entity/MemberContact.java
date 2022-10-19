package com.example.cloudmember.domains.entity;

import com.example.cloudmember.domains.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Builder
@Table(name = "member_contact")
@ToString(of = {"cel", "email"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@AttributeOverride(name = "idx", column = @Column(name = "contact_idx"))
public class MemberContact extends BaseEntity implements Serializable {
    @Column(name = "cell_phone")
    private String cel;

    private String email;

    @OneToOne(mappedBy = "contact", fetch = FetchType.LAZY)
    private Member member;

    // -- setter -- //
    public void setMember(Member member) {
        this.member = member;
    }


    // -- 내부 생성자 메서드 -- //
    public static MemberContact create(
        String cellPhone, String email
    ) {
        return MemberContact.builder()
            .cel(cellPhone)
            .email(email)
            .build();
    }
}
