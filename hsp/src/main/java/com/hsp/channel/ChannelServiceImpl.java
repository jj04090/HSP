package com.hsp.channel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.hsp.product.Product;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelMapper channelMapper;
	
	@Autowired
	private SubscribeMapper subscribeMapper;
	
//	@Override
//	public void registChannel(Channel channel) {
//		Channel getChannel = this.viewChannel(channel);
//		
//		if(getChannel != null) {
//			try {
//				channelMapper.insert(channel);
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}	
//	}
	
	@Override
	public void registChannel(Channel channel, MultipartFile attach) {
		try {
			String physicalName = this.imgUpload(attach);
			channel.setChannel_img(physicalName);
			channelMapper.insert(channel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateChannel(Channel channel, MultipartFile attach) {
		if (attach.isEmpty()) {
			try {
				channelMapper.update(channel);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				String physicalName = this.imgUpload(attach);
				channel.setChannel_img(physicalName);
				channelMapper.update(channel);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteChannel(Channel channel) {
		try {
			channelMapper.delete(channel);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Channel viewChannel(Channel channel) {
		try {
			return channelMapper.select(channel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Channel> viewChannelList() {
		try {
			return channelMapper.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public void startSubscribe(Subscribe subscribe) {
		List<Subscribe> getSubscribes = viewSubscribeList(subscribe);
		
		for(int i=0; i<getSubscribes.size(); i++) {
			if(subscribe.getChannel_id() != getSubscribes.get(i).getChannel_id()) {
				try {
					subscribeMapper.insert(subscribe);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void finishSubscribe(Subscribe subscribe) {
		List<Subscribe> getSubscribes = viewSubscribeList(subscribe);
		
		for(int i=0; i<getSubscribes.size(); i++) {
			if(subscribe.getChannel_id() == getSubscribes.get(i).getChannel_id()) {
				try {
					subscribeMapper.delete(subscribe);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public Subscribe viewSubscribe(Subscribe subscribe) {
		try {
			return subscribeMapper.select(subscribe);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Subscribe> viewSubscribeList(Subscribe subscribe) {
		try {
			return subscribeMapper.list(subscribe);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String imgUpload(MultipartFile attach) {
		String savePath = "C:\\Users\\ws059\\project";
		String logicalName = attach.getOriginalFilename();
		String physicalName = UUID.randomUUID().toString() + "_" + logicalName;
		
		try {
			attach.transferTo(new File(savePath + File.separator + physicalName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return physicalName;
	}

	@Override
	public ResponseEntity<Resource> display(String fileName) {
		String uploadPath = "C:\\Users\\ws059\\project\\";
		Resource resource = new FileSystemResource(uploadPath + fileName);
		
		if (!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		Path filePath = null;
		
		try {
			filePath = Paths.get(uploadPath + fileName);
			header.add("Content-Type", Files.probeContentType(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

	@Override
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, MultipartFile upload) {
		String uploadPath = "C:\\Users\\ws059\\project"; // 기본 경로
		// 랜덤 문자 생성
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
				
		// 인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			
			String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
			byte[] bytes = upload.getBytes();
			
			// 업로드 경로
//			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName; //origin
			String ckUploadPath = uploadPath + File.separator + uid + "_" + fileName;
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();  // out에 저장된 데이터를 전송하고 초기화
			
			printWriter = res.getWriter();
			String fileUrl = "/channel/display?filename=" + uid + "_" + fileName;  // 작성화면
			
			// 업로드시 메시지 출력
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			
			printWriter.flush();
			
		} catch (IOException e) { e.printStackTrace();
		} finally {
			try {
				if(out != null) { out.close(); }
				if(printWriter != null) { printWriter.close(); }
			} catch(IOException e) { e.printStackTrace(); }
		} 
		
		return;	
	}

}