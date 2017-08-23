package top.xiesen.video.web.controller;


import java.sql.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.xiesen.video.model.Speaker;
import top.xiesen.video.service.SpeakerService;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

	@Autowired
	SpeakerService ss;
	
	@RequestMapping("/speakerList.action")
	public String speakerList(Model model){
		List<Speaker> list = ss.selectAllSpeaker();
		model.addAttribute("speakerList", list);
		return "speaker/speakerList";
	}
	
	@RequestMapping("/addSpeaker.action")
	public String addSpeaker(){
		return "speaker/addSpeaker";
	}
	
	@RequestMapping(value="/addSpeaker.action",method = RequestMethod.POST)
	public String DoAddSpeaker(String speaker_name,String speaker_job,String speaker_head_url,String speaker_descr){
		Speaker speaker = new Speaker();
		speaker.setSpeaker_name(speaker_name);
		speaker.setSpeaker_job(speaker_job);
		speaker.setSpeaker_head_url(speaker_head_url);
		speaker.setSpeaker_descr(speaker_descr);
		speaker.setInsert_time(new Date(System.currentTimeMillis()));
		ss.addSpeaker(speaker);
		return "speaker/speakerList";
	}
	
	@RequestMapping("/selectSpeakerByNameAndJob.action")
	public String selectSpeakerByNameAndJob(String speaker_name,String speaker_job,HttpServletRequest request){
		List<Speaker> list= ss.selectSpeakerByNameAndJob(speaker_name,speaker_job);
		request.setAttribute("speakerList", list);
		return "speaker/speakerList";
	}
	
	@RequestMapping("/deleteSpeaker.action")
	public String deleteSpeaker(int id){
		ss.deleteSpeakerById(id);
		return "redirect:/speaker/speakerList.action";
	}
	
	@RequestMapping("/editSpeaker.action")
	public String editSpeaker(int id ,HttpServletRequest request){
		Speaker speaker = ss.selectSpeakerById(id);
		request.setAttribute("speaker", speaker);
		return "speaker/editSpeaker";
	}
	
	@RequestMapping(value = "/editSpeaker.action",method = RequestMethod.POST)
	public String doEditSpeaker(String speaker_name,String speaker_job,String speaker_head_url,String speaker_descr,int id){
		Speaker speaker = new Speaker();
//		System.out.println("speaker_descr : " + speaker_descr);
		speaker.setId(id);
		speaker.setSpeaker_name(speaker_name);
		speaker.setSpeaker_job(speaker_job);
		speaker.setSpeaker_head_url(speaker_head_url);
		speaker.setSpeaker_descr(speaker_descr);
		speaker.setUpdate_time(new Date(System.currentTimeMillis()));
		ss.updateSpeakerById(speaker);
		return "redirect:/speaker/speakerList.action";
	}
	
}
