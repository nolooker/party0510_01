package com.party.controller;

import com.party.entity.Board;
import com.party.sevice.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService ;

    // 게시물 목록 보기
    @GetMapping(value = "/list")
    public String SelectAll(Model model){
        List<Board> boardList = boardService.SelectAll();
        model.addAttribute("list", boardList);
        return "/board/boardList";
    }

    // 게시물 상세 보기
    @GetMapping(value = "/detail/{no}")
    public String SelectOne(@PathVariable("no") Integer no, Model model){
        Board board = boardService.SelectOne(no);
        model.addAttribute("board", board) ;
        return "/board/boardDetail";

    }


}
