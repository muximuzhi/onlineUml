package com.onlineUml.item.controller;

import com.onlineUml.item.pojo.Kind;
import com.onlineUml.item.service.KindService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("kind")
public class KindController {
    private final KindService kindService;

    public KindController(KindService kindService) {
        this.kindService = kindService;
    }

    /**
     * 获取所有uml类别
     * @param id
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Kind>> getKindById(@RequestParam(value = "id", defaultValue ="0", required = false) Long id) {
        List<Kind> list = this.kindService.getAllKind(id);
        return ResponseEntity.ok(list);
    }
}
