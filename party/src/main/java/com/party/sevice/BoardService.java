package com.party.sevice;

import com.party.entity.Board;
import com.party.mapper.BoardMapperInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapperInterface boardMapperInterface;

    // 게시물 목록 보기
    public List<Board> SelectAll(){
        return boardMapperInterface.SelectAll();
    }

    // 게시물 상세 보기
    public Board SelectOne(Integer no){
        return boardMapperInterface.SelectOne(no);
    }

}
