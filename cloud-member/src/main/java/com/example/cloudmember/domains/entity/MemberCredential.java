package com.example.cloudmember.domains.entity;

import com.example.cloudmember.domains.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@Table(
    name = "member_credential",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_credential_account", columnNames = "account")
    }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@AttributeOverride(name = "idx", column = @Column(name = "credential_idx"))
public class MemberCredential extends BaseEntity implements Serializable {

    private String account;

    private String password;

    @Builder.Default
    private int failCount = 0;

    @OneToOne(mappedBy = "credential")
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}