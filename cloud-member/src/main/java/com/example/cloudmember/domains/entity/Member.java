package com.example.cloudmember.domains.entity;

import com.example.cloudmember.domains.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "idx", column = @Column(name = "member_idx"))
public class Member extends BaseEntity implements Serializable {
    @Embedded
    private MemberBasic basic;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "credential", foreignKey = @ForeignKey(name = "fk_member_to_credential"))
    private MemberCredential credential;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact", foreignKey = @ForeignKey(name = "fk_member_to_contact"))
    private MemberContact contact;

    @Builder
    public Member(MemberBasic basic, MemberCredential credential) {
        this.basic = basic;
        this.credential = credential;
    }

    public void changeBasic(MemberBasic afterMember) {
        this.basic = afterMember;
    }

    public void changeContact(MemberContact contact) {
        this.contact = contact;
    }

    public void addCredential(MemberCredential credential) {
        this.credential = credential;
        if (credential != null) {
            credential.setMember(this);
        }
    }

}
