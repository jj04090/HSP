package com.hsp.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelMapper channelMapper;
	
	@Autowired
	private SubscribeMapper subscribeMapper;
	
	@Override
	public void registChannel(Channel channel) {
		Channel getChannel = this.viewChannel(channel);
		
		if(getChannel != null) {
			try {
				channelMapper.insert(channel);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void updateChannel(Channel channel) {
		try {
			channelMapper.update(channel);
			
		}catch(Exception e) {
			e.printStackTrace();
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
	public List<Channel> viewChannelList(Channel channel) {
		try {
			return channelMapper.list(channel);
			
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


}