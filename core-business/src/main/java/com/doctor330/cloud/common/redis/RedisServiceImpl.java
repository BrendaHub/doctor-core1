package com.doctor330.cloud.common.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.doctor330.cloud.common.config.PassportRedis;
import com.doctor330.cloud.server.common.IRedisService;
import com.doctor330.common.utils.StringUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
@Service("redisService")
public class RedisServiceImpl implements IRedisService {

	@Override
	public boolean keyExists(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			// jedis = PassportRedis.getJedis();
			return jedis.exists(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public void addToRedis(String key, String value) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public void addToRedis(String key, String value, int expire) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
			jedis.expire(key, expire);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public String getRedisValueByKey(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			// jedis = PassportRedis.getJedis();
			String value = jedis.get(key);
			// String value = PassportRedis.safeGet(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return null;
	}

	public boolean deleteRedisValueByKey(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return true;
	}

	/**
	 * 操作指定用户和指定需求，申请洽谈的次数
	 */
	public long talkuserid_projectIdCount(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		long curcount = 0;
		try {
			jedis = pool.getResource();
			if (jedis.exists(key)) {
				curcount = jedis.incr(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return curcount;
	}

	@Override
	public boolean addProjectClickCount(String ip, int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			if (jedis.exists("p_click_count_ip_" + ip)) {
				if (!jedis.hexists("p_click_count_ip_" + ip, projectId + "")) {
					jedis.incr("p_click_count_" + projectId);
					jedis.hset("p_click_count_ip_" + ip, projectId + "", "0");
					jedis.incr("p_virtual_click_count_" + projectId);
				}
			} else {
				jedis.hset("p_click_count_ip_" + ip, projectId + "", "0");
				jedis.incr("p_click_count_" + projectId);
				jedis.incr("p_virtual_click_count_" + projectId);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addProjectClickCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("p_click_count_" + projectId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addDemandClickCount(String ip, int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			if (jedis.exists("d_click_count_ip_" + ip)) {
				if (!jedis.hexists("d_click_count_ip_" + ip, demandId + "")) {
					jedis.hset("d_click_count_ip_" + ip, demandId + "", "0");
					jedis.incr("d_click_count_" + demandId);
					jedis.incr("d_virtual_click_count_" + demandId);
				}
			} else {
				jedis.hset("d_click_count_ip_" + ip, demandId + "", "0");
				jedis.incr("d_click_count_" + demandId);
				jedis.incr("d_virtual_click_count_" + demandId);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addDemandClickCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("d_click_count_" + demandId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addProjectCollectionCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("p_collection_count_" + projectId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addDemandCollectionCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("d_collection_count_" + demandId);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addProjectApplyTalkCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("p_apply_count_" + projectId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addProjectDeliveryCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("p_delivery_count_" + projectId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addDemandApplyTalkCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("d_apply_count_" + demandId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addDemandDeliveryCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.incr("d_delivery_count_" + demandId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public int getProjectClickCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("p_click_count_" + projectId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public int getDemandClickCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("d_click_count_" + demandId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}
	
	@Override
	public int getProjectVirtualClickCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("p_virtual_click_count_" + projectId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return getProjectClickCount(projectId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return getProjectClickCount(projectId);
	}

	@Override
	public int getDemandVirtualClickCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("d_virtual_click_count_" + demandId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return getDemandClickCount(demandId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return getDemandClickCount(demandId);
	}

	@Override
	public int getProjectCollectionCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("p_collection_count_" + projectId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public int getDemandCollectionCount(int demandIdId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("d_collection_count_" + demandIdId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public int getProjectApplyTalkCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("p_apply_count_" + projectId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public int getProjectDeliveryCount(int projectId) {

		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("p_delivery_count_" + projectId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public int getDemandApplyTalkCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("d_apply_count_" + demandId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public int getDemandDeliveryCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("d_delivery_count_" + demandId);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addMyApplyMessageFlag(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("my_apply_message_flag_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getMyApplyMessageFlag(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("my_apply_message_flag_" + key);
			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addSubmitProjectMessageFlag(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("submit_project_message_flag_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getSubmitProjectMessageFlag(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("submit_project_message_flag_" + key);
			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addSystemMessageFlag(String messageId, int expire) {
		String key = "system_message";
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, messageId);
			if (expire > 0) {
				jedis.expire(key, expire * 24 * 60 * 60);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public String getNewestSystemMessageId(int userId) {
		String value = null;
		String key = "system_message";
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			value = jedis.get(key);
			if (value != null) {
				String hKey = "read_system_message_ids_" + value;
				if (jedis.hexists(hKey, userId + "")) {
					value = null;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return value;
	}

	public boolean setSystemMessageHaveRead(int userId) {
		String key = "system_message";
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get(key);
			if (value != null) {
				String hKey = "read_system_message_ids_" + value;
				jedis.hset(hKey, userId + "", value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean addFriendApplyMessageCount(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("friend_apply_message_count_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getFriendApplyMessageCount(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("friend_apply_message_count_" + key);
			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addFriendApplyAgreeMessageCount(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("friend_apply_agree_message_count_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getFriendApplyAgreeMessageCount(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("friend_apply_agree_message_count_" + key);
			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addSubmitProjectAgreeCount(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("submit_project_agree_count_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getSubmitProjectAgreeCount(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("submit_project_agree_count_" + key);
			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addApplyTalkerAgreeCount(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("apply_talker_agree_count_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getApplyTalkerAgreeCount(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("apply_talker_agree_count_" + key);
			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean addSystemMessageCount(String key, String count) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("system_message_count_" + key, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public Integer getSystemMessageCount(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String value = jedis.get("system_message_count_" + key);

			if (!StringUtil.isNullorBlank(value)) {
				return Integer.parseInt(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return 0;
	}

	@Override
	public boolean setQrParam(String key, String message) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public String getQrParam(String key) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return "";
	}

	@Override
	public boolean decreaseProjectCollectionCount(int projectId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.decr("p_collection_count_" + projectId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	@Override
	public boolean decreaseDemandCollectionCount(int demandId) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.decr("d_collection_count_" + demandId);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return false;
	}

	public static void main(String[] args) {
		JedisPool pool = PassportRedis.getPool();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			System.out.println(jedis.get("d_click_count_" + 154));
			jedis.incr("d_click_count_" + 154);
			System.out.println(jedis.get("d_click_count_" + 154));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	@Override
	public Map<String, Integer> getClickCount(Integer businessId, Integer businessType, Integer flag) {
		Map<String, Integer> clickCountMap = new HashMap<String, Integer>();
		Integer realClickCount = 0;
		Integer virtualClickCount = 0;
		
		try {
			if (businessId == null || businessType == null || flag == null) {
				clickCountMap.put("realClickCount", realClickCount);
				clickCountMap.put("virtualClickCount", virtualClickCount);
				return clickCountMap;
			}
			if (businessType == 0) {
				if (flag == 0) {
					realClickCount = getProjectClickCount(businessId);
					virtualClickCount = getProjectVirtualClickCount(businessId);
					clickCountMap.put("realClickCount", realClickCount);
					clickCountMap.put("virtualClickCount", virtualClickCount);
				} else {
					realClickCount = getProjectClickCount(businessId);
					virtualClickCount = getProjectVirtualClickCount(businessId);
					clickCountMap.put("realClickCount", realClickCount);
					clickCountMap.put("virtualClickCount", virtualClickCount);
				}
			} else if (businessType == 1) {
				if (flag == 0) {
					realClickCount = getDemandClickCount(businessId);
					virtualClickCount = getDemandVirtualClickCount(businessId);
					clickCountMap.put("realClickCount", realClickCount);
					clickCountMap.put("virtualClickCount", virtualClickCount);
				} else {
					realClickCount = getDemandClickCount(businessId);
					virtualClickCount = getDemandVirtualClickCount(businessId);
					clickCountMap.put("realClickCount", realClickCount);
					clickCountMap.put("virtualClickCount", virtualClickCount);
				}
			}
		} catch (Exception e) {
			clickCountMap.put("realClickCount", realClickCount);
			clickCountMap.put("virtualClickCount", virtualClickCount);
			e.printStackTrace();
		}

		return clickCountMap;
	}
}
