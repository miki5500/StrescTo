package com.strescTo.controller;

import com.strescTo.tokenizer.entity.Article;
import com.strescTo.tokenizer.entity.Sentence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class summarizerController {

    @GetMapping(value = {"/index","/"})
    public String getMainPage()
    {
        return "index";
    }

    @GetMapping("/summarizeForm")
    public String getSummarizerForm(Model model)
    {
        Article article = new Article();
        model.addAttribute("article",article);
        return "summarizeForm";
    }

    @PostMapping("/summarize")
    public String summarize(@ModelAttribute("article") Article article,Model model)
    {
        Article art = article;
        art.setParagraphs();

        model.addAttribute("paragraphs",art.getParagraphs().get(0).getText());
        return "viewSummary";
    }

}
