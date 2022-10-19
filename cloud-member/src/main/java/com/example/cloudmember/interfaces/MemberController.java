package com.example.cloudmember.interfaces;

import com.example.cloudmember.applications.DefaultMemberService;
import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.dto.ResponseMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final DefaultMemberService defaultMemberService;

    @PostMapping("")
    public ResponseEntity<ResponseMember> createMember(@RequestBody RequestMember requestMember) {

        ResponseMember responseMember = defaultMemberService.saveMember(requestMember);

        URL url = new URL("/members/" + responseMember.getId());

        return ResponseEntity.created(url).body(responseMember);

    }
}
