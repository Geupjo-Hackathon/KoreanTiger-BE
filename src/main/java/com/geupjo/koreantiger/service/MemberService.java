package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.common.exception.CustomException;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.NO_MATCH_USER_EXCEPTION));
    }
}
