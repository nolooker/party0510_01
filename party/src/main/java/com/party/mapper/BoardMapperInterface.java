package com.party.mapper;

import com.party.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapperInterface {
    // 게시물 목록 보기
    @Select("select * from boards")
    List<Board> SelectAll();

    // 게시물 상세보기
    @Select("select * from boards where no = #{no}")
    Board SelectOne(@Param("no") Integer no);

}
