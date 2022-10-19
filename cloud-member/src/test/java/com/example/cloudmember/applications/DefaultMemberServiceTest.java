package com.example.cloudmember.applications;

import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.repository.MemberRepository;
import com.example.cloudmember.exception.AreadyExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultMemberServiceTest {

    private DefaultMemberService defaultMemberService;

    @Mock
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.defaultMemberService = new DefaultMemberService(memberRepository);
    }

    @Test
    void saveMember() {
        String username = "pgt";
        String cel = "010-0000-0000";
        String email = "mail@m.m";
        String account = "iln1027";

        RequestMember requestMember = getRequestMember(username, cel, email, account);

        this.defaultMemberService.saveMember(requestMember);

        verify(this.memberRepository).save(any());
    }

    @Test
    @Rollback(value = false)
    void saveMemberFailed() {
        String username = "pgt";
        String cel = "010-0000-0000";
        String email = "mail@m.m";
        String account = "iln1027";

        RequestMember requestMember = getRequestMember(username, cel, email, account);

        this.defaultMemberService.saveMember(requestMember);

        Assertions.assertThrows(AreadyExistException.class, () -> {
            RequestMember requestMember2 = getRequestMember(username, cel, email, account);
            this.defaultMemberService.saveMember(requestMember2);
        });

        verify(memberRepository, never()).save(any());

    }

    private static RequestMember getRequestMember(String username, String cel, String email, String account) {
        RequestMember requestMember = new RequestMember();
        requestMember.setAccount(account);
        requestMember.setCel(cel);
        requestMember.setEmail(email);
        requestMember.setUsername(username);
        return requestMember;
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateMember() {
    }
}