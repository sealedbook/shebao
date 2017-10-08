package net.vicp.sealedbook.controller.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.vicp.sealedbook.common.consts.SystemConst;
import net.vicp.sealedbook.entity.Customer;
import net.vicp.sealedbook.entity.dto.SystemMenuDTO;
import net.vicp.sealedbook.entity.dto.SystemUserDTO;
import net.vicp.sealedbook.processor.system.SystemMenuProcessor;

@Controller
public class WorkFrameController {

	@Resource
	private SystemMenuProcessor systemMenuProcessor;

	@RequestMapping("/work/frame")
	public String framePage(HttpSession session,HttpServletRequest request,Model model) {
		Customer customer = new Customer(request);
		model.addAttribute("customer", customer);
		return "/frame/frame";
	}
	
	@RequestMapping("/work/frame/leftPage")
	public String frameLeftPage(HttpServletRequest request,Model model) {
		model.addAttribute("customer", new Customer(request));
		model.addAttribute("loginTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return "/frame/left";
	}

	@RequestMapping("/frame/rightPage")
	public String frameRightPage() {
		return "/frame/right";
	}

	@RequestMapping("/work/frame/menus")
	public String frameMenusPage(HttpSession session,Model model) {
		SystemUserDTO user = (SystemUserDTO)session.getAttribute(SystemConst.SESSION_USER_KEY);
		List<SystemMenuDTO> menu = systemMenuProcessor.getMenu(user.getId());
		model.addAttribute("menus", menu);
		return "/frame/menus";
	}
}
