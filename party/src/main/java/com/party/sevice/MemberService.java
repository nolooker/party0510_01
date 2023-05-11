package com.party.sevice;

import com.party.entity.Member;
import com.party.mapper.MemberMapperInterface;
import com.party.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final MemberMapperInterface memberMapperInterface ;


    public Member SelectOne(Long id){
        return memberMapperInterface.SelectOne(id) ;
    }

    public List<Member> SelectAll(){
        return memberMapperInterface.SelectAll();
    }

    public int Update(Member member){
        return memberMapperInterface.updateMember(member);
    }
    public int Delete(Long id) {
        return memberMapperInterface.Delete(id);
    }


    @Override //Securityconfig 에 usernameParameter("email") 과 같은
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member=memberRepository.findByEmail(email);
        if(member==null){ //회원이 존재하지 않는 경우 입니다.
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

    public Member saveMember(Member member){
        validateDuplicateMember(member);

        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember= memberRepository.findByEmail(member.getEmail());
        if(findMember!=null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }




}
