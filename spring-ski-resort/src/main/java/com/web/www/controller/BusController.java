package com.web.www.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.www.domain.bus.BusInfoVO;
import com.web.www.domain.bus.BusVO;
import com.web.www.domain.member.AuthUser;
import com.web.www.domain.member.MemberVO;
import com.web.www.service.BusService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/bus/*")
@RequiredArgsConstructor
public class BusController {
	
	private final BusService bsv;
	
	
	@GetMapping("/busMap")
	public String busMap() {
		return "/bus/busMap";
	}
	
<<<<<<< HEAD
	@GetMapping("/busGuid")
	public String busGuid() {
		return "/bus/busGuid";
=======
	@GetMapping("/busReserve")
	public String busReserveForm(@AuthUser MemberVO mvo, Model model, BusInfoVO bivo) {
		log.info("bus mvo = {}",mvo);
		model.addAttribute("mvo", mvo);
		model.addAttribute("bivo", bivo);
		return "/bus/busReserve";
	}
	
	@PostMapping("busReserve")
	public String busReservePost(BusVO bvo) {
		log.info("BusVO bvo = {}",bvo);
		int isOk = bsv.busReserve(bvo);
		log.info((isOk > 0)? "ok":"fail");
		return "index";
	}
	
	@PostConstruct
	public void addBusList() {
		int busCount = bsv.busCount();
		
		if(busCount == 0) {
			List<BusInfoVO> busList = new ArrayList<BusInfoVO>();
			busList.add(new BusInfoVO(1001, "강남선", 30));
			busList.add(new BusInfoVO(1002, "광화문", 30));
			busList.add(new BusInfoVO(1003, "분당선", 30));
			busList.add(new BusInfoVO(1004, "수원선", 30));
			busList.add(new BusInfoVO(1005, "잠실선", 30));
			busList.add(new BusInfoVO(1006, "천안-평택선", 30));
			for(int i = 0; i < busList.size(); i++) {
				bsv.addBusInfo(busList.get(i));
			}
		}
>>>>>>> 80e675c8045fc53e2f290360a4a7eba0164276ff
	}

}
