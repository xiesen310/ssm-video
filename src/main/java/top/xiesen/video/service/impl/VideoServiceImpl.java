package top.xiesen.video.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xiesen.video.mapper.VideoMapper;
import top.xiesen.video.model.Video;
import top.xiesen.video.service.VideoService;
import top.xiesen.video.utils.Page;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoMapper vm;
	
	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(String video_title, String speaker_name, String course_name,int page) {
		Page<Video> pages = new Page<>();
		pages.setPage(page);
		pages.setRows(vm.selectVideo(video_title, speaker_name, course_name,(page-1)*5));
		pages.setSize(5);
		pages.setTotal(vm.selectVideoCount(video_title, speaker_name, course_name));
		return pages;
	}

	@Override
	public void insertVideo(Video video) {
		vm.insertVideo(video);
		
	}

	@Override
	public void deleteBatch(String[] id) {
		for (String string : id) {
			vm.deleteBatch(Integer.parseInt(string));
		}
	}

	@Override
	public void deleteById(int delid) {
		vm.deleteBatch(delid);
	}

	@Override
	public Video selectVideoById(int id) {
		return vm.selectVideoById(id);
	}

	@Override
	public void updateVideo(Video video) {
		
		vm.updateVideo(video);
	}

	@Override
	public List<Video> selectAllVideo() {
		// TODO Auto-generated method stub
		return vm.selectAllVideo();
	}

}
