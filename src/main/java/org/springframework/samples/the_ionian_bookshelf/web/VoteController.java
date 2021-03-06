package org.springframework.samples.the_ionian_bookshelf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.the_ionian_bookshelf.service.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VoteController {

	private VoteService voteService;
	
	@Autowired
	public VoteController(final VoteService voteService) {
		this.voteService = voteService;
	}
	
	@GetMapping("/threads/{threadId}/upVote")
	public String upVoteThread(ModelMap map, @PathVariable("threadId") int threadId) {
		
		try {
			voteService.createUpVoteByThreadId(threadId);	
		} catch (AssertionError e) {
			return "/votes/voteError";
		}
		return "redirect:/threads";
	}
	
	@GetMapping("/threads/{threadId}/downVote")
	public String downVoteThread(ModelMap map, @PathVariable("threadId") int threadId) {
		
		try {
			voteService.createDownVoteByThreadId(threadId);	
		} catch (AssertionError e) {
			return "/votes/voteError";
		}
		return "redirect:/threads";
	}
	
	@GetMapping("threads/{threadId}/message/{messageId}/upVote")
	public String upVoteMessage(ModelMap map, @PathVariable("threadId") int threadId, @PathVariable("messageId") int messageId) {
		
		try {
			voteService.createUpVoteByMessageId(messageId);	
		} catch (AssertionError e) {
			return "/votes/voteError";
		}
		return "redirect:/threads/"+threadId;
	}
	
	@GetMapping("threads/{threadId}/message/{messageId}/downVote")
	public String downVoteMessage(ModelMap map, @PathVariable("threadId") int threadId,@PathVariable("messageId") int messageId) {
		
		try {
			voteService.createDownVoteByMessageId(messageId);	
		} catch (AssertionError e) {
			return "/votes/voteError";
		}
		return "redirect:/threads/"+threadId;
	}
	
	@GetMapping("builds/{buildId}/upVote")
	public String upVoteBuild(ModelMap map, @PathVariable("buildId") int buildId) {
		
		try {
			voteService.createUpVoteByBuildId(buildId);	
		} catch (AssertionError e) {
			return "/votes/voteError";
		}
		return "redirect:/builds";
	}
	
	@GetMapping("builds/{buildId}/downVote")
	public String downVoteBuild(ModelMap map, @PathVariable("buildId") int buildId) {
		
		try {
			voteService.createDownVoteByBuildId(buildId);	
		} catch (AssertionError e) {
			return "/votes/voteError";
		}
		return "redirect:/builds";
	}
}
