package com.doctor330.cloud.server.common;

import java.util.Map;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
public interface IRedisService {


	/**
	 * 验证redis是否存在key
	 * @param key
	 * @return
     */
	boolean keyExists(String key);

    /**
     *设置redis值
     * @param key
     * @param value
     */
    void addToRedis(String key, String value );

    /**
     *
     * @param key
     * @param value
     * @param expire 秒 key存活时间
     */
    void addToRedis(String key, String value, int expire);

    /**
     *
     * @param key
     * @return
     */
    String getRedisValueByKey(String key);

    /**
     *
     * @param key
     * @return
     */
    boolean deleteRedisValueByKey(String key);

    /**
     * 项目的点击量
     * @param ip
     * @param projectId
     * @return
     */
    boolean addProjectClickCount(String ip, int projectId);
    
    /**
     * 项目的 pv
     * @param projectId
     * @return
     */
    boolean addProjectClickCount(int projectId);

    /**
     * 需求的点击量
     * @param ip
     * @param demandId
     * @return
     */
    boolean addDemandClickCount(String ip, int demandId);
    
    /**
     * 需求的 pv
     * @param demandId
     * @return
     */
    boolean addDemandClickCount(int demandId);

    /**
     * 项目的收藏量
     * @param projectId
     * @return
     */
    boolean addProjectCollectionCount(int projectId);

    /**
     * 需求的收藏量
     * @param demandId
     * @return
     */
    boolean addDemandCollectionCount(int demandId);
    
    
    /**
     * 项目的收藏量递减
     * @param projectId
     * @return
     */
    boolean decreaseProjectCollectionCount(int projectId);

    /**
     * 需求的收藏量递减
     * @param demandId
     * @return
     */
    boolean decreaseDemandCollectionCount(int demandId);

    

    /**
     * 项目的洽谈量
     * @param projectId
     * @return
     */
    boolean addProjectApplyTalkCount(int projectId);

    /**
     * 项目的投递量
     * @param projectId
     * @return
     */
    boolean addProjectDeliveryCount(int projectId);

    /**
     * 需求的洽谈量
     * @param demand
     * @return
     */
    boolean addDemandApplyTalkCount(int demand);

    /**
     * 需求的投递量
     * @param demand
     * @return
     */
    boolean addDemandDeliveryCount(int demand);

    /**
     * 项目的点击量
     * @param projectId
     * @return
     */
    int getProjectClickCount(int projectId);

    /**
     * 需求的点击量
     * @param demandId
     * @return
     */
    int getDemandClickCount(int demandId);
    /**
     * 获取项目的虚拟点击量
     * @param projectId
     * @return
     */
    int getProjectVirtualClickCount(int projectId);

    /**
     *  获取需求的虚拟点击量
     * @param demandId
     * @return
     */
    int getDemandVirtualClickCount(int demandId);
    

    /**
     * 项目的收藏量
     * @param projectId
     * @return
     */
    int getProjectCollectionCount(int projectId);

    /**
     * 需求的收藏量
     * @param demandId
     * @return
     */
    int getDemandCollectionCount(int demandId);

    /**
     * 项目的洽谈量
     * @param projectId
     * @return
     */
    int getProjectApplyTalkCount(int projectId);

    /**
     * 项目投递过多少需求
     * @param projectId
     * @return
     */
    int getProjectDeliveryCount(int projectId);
    /**
     * 需求的洽谈量
     * @param demandId
     * @return
     */
    int getDemandApplyTalkCount(int demandId);

    /**
     * 需求的投递量
     * @param demandId
     * @return
     */
    int getDemandDeliveryCount(int demandId);

	/**
	 * 存储我的洽谈是否有新消息标识
	 *
	 * @param key
	 *            用户id
	 * @return count 新消息数量
	 * @author wqw
	 */
	boolean addMyApplyMessageFlag(String key, String count);

	/**
	 * 获取我的洽谈是否有新消息标识
	 *
	 * @param key
	 *            用户id
	 * @return count 新消息数量
	 * @author wqw
	 */
	Integer getMyApplyMessageFlag(String key);

	/**
	 * 存储新投递的项目个数
	 *
	 * @param key
	 *            用户id
	 * @return count 新消息数量
	 * @author wqw
	 */
	boolean addSubmitProjectMessageFlag(String key, String count);

	/**
	 * 获取我的洽谈是否有新消息标识
	 *
	 * @param key
	 *            用户id
	 * @return count 新消息数量
	 * @author wqw
	 */
	Integer getSubmitProjectMessageFlag(String key);


	/**
	 * 存储好友申请消息个数
	 * @param key 用户ID
	 * @param count 新消息数量
	 * @return
	 */
	boolean addFriendApplyMessageCount(String key, String count);

	/**
	 * 获取好友申请消息个数
	 * @param key 用户ID
	 * @return
	 */
	Integer getFriendApplyMessageCount(String key);

	/**
	 * 存储同意我的好友申请消息的个数
	 * @param key 用户ID
	 * @param count 消息的个数
	 * @return
	 */
	boolean addFriendApplyAgreeMessageCount(String key, String count);

	/**
	 * 获取同意我的好友申请消息个数
	 * @param key用户ID
	 * @return
	 */
	Integer getFriendApplyAgreeMessageCount(String key);

	/**
	 * 添加投递项目匹配消息的个数
	 * @param key 用户ID
	 * @param count 消息的个数
	 * @return
	 */
	boolean addSubmitProjectAgreeCount(String key, String count);

	/**
	 * 获取投递项目匹配消息的个数
	 * @param key 用户ID
	 * @return
	 */
	Integer getSubmitProjectAgreeCount(String key);

	/**
	 * 添加申请洽谈统一的个数
	 * @param key 用户ID
	 * @param count 消息的个数
	 * @return
	 */
	boolean addApplyTalkerAgreeCount(String key, String count);

	/**
	 * 获取申请洽谈同意的个数
	 * @param key 用户ID
	 * @return
	 */
	Integer getApplyTalkerAgreeCount(String key);

	/**
	 * 添加系统消息个数
	 * @param key 用户ID
	 * @param count 消息的个数
	 * @return
	 */
	boolean addSystemMessageCount(String key, String count);

	/**
	 * 获取系统消息个数
	 * @param key 用户ID
	 * @return
	 */
	Integer getSystemMessageCount(String key);


    /**
     * 设置标记告知用户有系统消息
     * @param messageId 系统消息编码
     * @param expire 消息存在时间
     * @return
     */
    boolean addSystemMessageFlag(String messageId, int expire);

    /**
     * 获取系统消息标记
     * @return 系统消息编码
     */
    String getNewestSystemMessageId(int userId);

    /**
     * 记录用户已经点击网站的系统消息链接
     * @param userId
     * @return
     */
    boolean setSystemMessageHaveRead(int userId);


	String getQrParam(String key);

	boolean setQrParam(String key, String message);
	
	/**
	 * 获取项目或需求的真实点击量和虚拟点击量
	 * @param businessId 项目或需求ID
	 * @param businessType 类型，0：表示项目，1表示需求
	 * @param flag 标记 0：表示普通项目（需求）1：表示企业项目（需求）
	 * @return Map<String, Integer>， key=realClickCount：真实的浏览量；key=virtualClickCount：虚拟的浏览量
	 */
	Map<String, Integer> getClickCount(Integer businessId,Integer businessType, Integer flag);


}
