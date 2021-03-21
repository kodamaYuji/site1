package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class MainController {
@RequestMapping("/")
public ModelAndView index(ModelAndView mv) {
mv.setViewName("index");
return mv;
}
@RequestMapping("/test")
public ModelAndView test(ModelAndView mv) {
mv.setViewName("index");
return mv;
}

//-------------------------------------------------------------------
//-------------------------------------------------------------------

@RequestMapping(value="/test2", method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv){
mv.addObject("name", "名前がここに入ります");
mv.addObject("age", "年齢がここに入ります");
mv.addObject("height", "身長がここに入ります");
mv.addObject("onOff1", false); //非表示
mv.addObject("onOff2", false); //表示
mv.setViewName("index");
return mv;
}
@RequestMapping(value="/test2", method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv, @RequestParam("nameVal")String
name,
@RequestParam("ageVal")String age, @RequestParam("heightVal")String height){
mv.addObject("name", name);
mv.addObject("age", age);
mv.addObject("height", height);
mv.addObject("onOff1", true); //表示
mv.addObject("onOff2", true); //非表示
mv.setViewName("index");
return mv;
}/*
@RequestMapping("/test2/{name}")
public ModelAndView index(@PathVariable String name, ModelAndView mv){ //nameをStringと認識させる
mv.addObject("name", name);
mv.setViewName("index");
return mv;
}
*/
@RequestMapping("/test2/{num}")//urlに半角整数を入れ、その分ループする
public ModelAndView index(@PathVariable int num, ModelAndView mv){
String line="";
for(int i=0; i<num; i++) line+="田";
mv.addObject("name", line);
mv.setViewName("index");
return mv;
}
}
