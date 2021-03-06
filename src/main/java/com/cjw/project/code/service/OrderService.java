package com.cjw.project.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cjw.project.code.po.OrderPO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.web.MysqlDBException;

@Service("OrderService")
public class OrderService extends BaseService<OrderPO> {

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 新增对象
	 * 
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTOrder(OrderPO obj) throws MysqlDBException {
		if (ObjectUtil.isEmpty(obj)) {
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空", e);
			throw e;
		}
		this.insert(obj);
	}

	/**
	 * 更新单个对象
	 * 
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateTOrder(OrderPO obj) throws MysqlDBException {
		if (ObjectUtil.isEmpty(obj)) {
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空", e);
			throw e;
		}
		this.update(obj);
	}

	/**
	 * 通过主键删除对象
	 * 
	 * @param id
	 * @throws MysqlDBException
	 */
	public void deleteTOrderById(String id) throws MysqlDBException {
		if (ObjectUtil.isEmpty(id)) {
			MysqlDBException e = new MysqlDBException("通过主键删除对象，主键 id 不能为空");
			log.error("通过主键删除对象，主键 id 不能为空", e);
			throw e;
		}
		this.delete(id);
	}

	/**
	 * 通过主键 查询对象
	 * 
	 * @param id
	 * @throws MysqlDBException
	 */
	public OrderPO getTOrderById(String id) throws MysqlDBException {
		if (ObjectUtil.isEmpty(id)) {
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空", e);
			throw e;
		}
		return this.get(id);
	}

	/**
	 * 条件查询返回分页列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public Paged<OrderPO> queryPageTOrder(Integer pageNo, Integer pageSize, OrderPO obj) throws MysqlDBException {
		if (ObjectUtil.isEmpty(obj)) {
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常", e);
			throw e;
		}
		Query<OrderPO> q = Query.build(OrderPO.class);
		q.setPaged(pageNo, pageSize);

		if (!ObjectUtil.isEmpty(obj.getId()))
			q.addEq("id", obj.getId());
		if (!ObjectUtil.isEmpty(obj.getCommodityId()))
			q.addEq("commodityId", obj.getCommodityId());
		if (!ObjectUtil.isEmpty(obj.getPictureId()))
			q.addEq("pictureId", obj.getPictureId());
		if (!ObjectUtil.isEmpty(obj.getPrice()))
			q.addEq("price", obj.getPrice());
		if (!ObjectUtil.isEmpty(obj.getNum()))
			q.addEq("num", obj.getNum());
		if (!ObjectUtil.isEmpty(obj.getSellerId()))
			q.addEq("sellerId", obj.getSellerId());
		if (!ObjectUtil.isEmpty(obj.getBuyerId()))
			q.addEq("buyerId", obj.getBuyerId());
		if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()))
				q.addGt("creartTime", obj.getCreartTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))
				q.addLt("creartTime", obj.getCreartTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()) && !ObjectUtil.isEmpty(obj.getPayTimeEnd())) {
			q.addBetween("payTime", obj.getPayTimeBegin(), obj.getPayTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()))
				q.addGt("payTime", obj.getPayTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getPayTimeEnd()))
				q.addLt("payTime", obj.getPayTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getState()))
			q.addEq("state", obj.getState());
		if (!ObjectUtil.isEmpty(obj.getAddress()))
			q.addEq("address", obj.getAddress());
		if (!ObjectUtil.isEmpty(obj.getIsSign()))
			q.addEq("isSign", obj.getIsSign());
		if (!ObjectUtil.isEmpty(obj.getIsPay()))
			q.addEq("isPay", obj.getIsPay());
		if (!ObjectUtil.isEmpty(obj.getLogisticsCode()))
			q.addEq("logisticsCode", obj.getLogisticsCode());

		// q.addOrder("createtime", DBOrder.DESC);
		Paged<OrderPO> page = this.findPagedByQuery(q);
		return page;
	}

	/**
	 * 条件查询 返回列表
	 * 
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<OrderPO> queryListTOrderByParam(OrderPO obj) throws MysqlDBException {
		if (ObjectUtil.isEmpty(obj)) {
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常", e);
			throw e;
		}
		Query<OrderPO> q = Query.build(OrderPO.class);

		if (!ObjectUtil.isEmpty(obj.getId()))
			q.addEq("id", obj.getId());
		if (!ObjectUtil.isEmpty(obj.getCommodityId()))
			q.addEq("commodityId", obj.getCommodityId());
		if (!ObjectUtil.isEmpty(obj.getPictureId()))
			q.addEq("pictureId", obj.getPictureId());
		if (!ObjectUtil.isEmpty(obj.getPrice()))
			q.addEq("price", obj.getPrice());
		if (!ObjectUtil.isEmpty(obj.getNum()))
			q.addEq("num", obj.getNum());
		if (!ObjectUtil.isEmpty(obj.getSellerId()))
			q.addEq("sellerId", obj.getSellerId());
		if (!ObjectUtil.isEmpty(obj.getBuyerId()))
			q.addEq("buyerId", obj.getBuyerId());
		if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()))
				q.addGt("creartTime", obj.getCreartTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))
				q.addLt("creartTime", obj.getCreartTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()) && !ObjectUtil.isEmpty(obj.getPayTimeEnd())) {
			q.addBetween("payTime", obj.getPayTimeBegin(), obj.getPayTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()))
				q.addGt("payTime", obj.getPayTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getPayTimeEnd()))
				q.addLt("payTime", obj.getPayTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getState()))
			q.addEq("state", obj.getState());
		if (!ObjectUtil.isEmpty(obj.getAddress()))
			q.addEq("address", obj.getAddress());
		if (!ObjectUtil.isEmpty(obj.getIsSign()))
			q.addEq("isSign", obj.getIsSign());
		if (!ObjectUtil.isEmpty(obj.getIsPay()))
			q.addEq("isPay", obj.getIsPay());
		if (!ObjectUtil.isEmpty(obj.getLogisticsCode()))
			q.addEq("logisticsCode", obj.getLogisticsCode());
		return this.findByQuery(q);
	}

	/**
	 * 条件查询 返回对象实体
	 * 
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public OrderPO getTOrderByParam(OrderPO obj) throws MysqlDBException {
		if (ObjectUtil.isEmpty(obj)) {
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常", e);
			throw e;
		}
		Query<OrderPO> q = Query.build(OrderPO.class);

		if (!ObjectUtil.isEmpty(obj.getId()))
			q.addEq("id", obj.getId());
		if (!ObjectUtil.isEmpty(obj.getCommodityId()))
			q.addEq("commodityId", obj.getCommodityId());
		if (!ObjectUtil.isEmpty(obj.getPictureId()))
			q.addEq("pictureId", obj.getPictureId());
		if (!ObjectUtil.isEmpty(obj.getPrice()))
			q.addEq("price", obj.getPrice());
		if (!ObjectUtil.isEmpty(obj.getNum()))
			q.addEq("num", obj.getNum());
		if (!ObjectUtil.isEmpty(obj.getSellerId()))
			q.addEq("sellerId", obj.getSellerId());
		if (!ObjectUtil.isEmpty(obj.getBuyerId()))
			q.addEq("buyerId", obj.getBuyerId());
		if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()))
				q.addGt("creartTime", obj.getCreartTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))
				q.addLt("creartTime", obj.getCreartTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()) && !ObjectUtil.isEmpty(obj.getPayTimeEnd())) {
			q.addBetween("payTime", obj.getPayTimeBegin(), obj.getPayTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()))
				q.addGt("payTime", obj.getPayTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getPayTimeEnd()))
				q.addLt("payTime", obj.getPayTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getState()))
			q.addEq("state", obj.getState());
		if (!ObjectUtil.isEmpty(obj.getAddress()))
			q.addEq("address", obj.getAddress());
		if (!ObjectUtil.isEmpty(obj.getIsSign()))
			q.addEq("isSign", obj.getIsSign());
		if (!ObjectUtil.isEmpty(obj.getIsPay()))
			q.addEq("isPay", obj.getIsPay());
		if (!ObjectUtil.isEmpty(obj.getLogisticsCode()))
			q.addEq("logisticsCode", obj.getLogisticsCode());
		return this.get(q);
	}

	/**
	 * 导出excel 数据表
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTOrderForExl(OrderPO obj) throws MysqlDBException {
		if (ObjectUtil.isEmpty(obj)) {
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常", e);
			throw e;
		}
		Query<OrderPO> q = Query.build(OrderPO.class);

		if (!ObjectUtil.isEmpty(obj.getId()))
			q.addEq("id", obj.getId());
		if (!ObjectUtil.isEmpty(obj.getCommodityId()))
			q.addEq("commodityId", obj.getCommodityId());
		if (!ObjectUtil.isEmpty(obj.getPictureId()))
			q.addEq("pictureId", obj.getPictureId());
		if (!ObjectUtil.isEmpty(obj.getPrice()))
			q.addEq("price", obj.getPrice());
		if (!ObjectUtil.isEmpty(obj.getNum()))
			q.addEq("num", obj.getNum());
		if (!ObjectUtil.isEmpty(obj.getSellerId()))
			q.addEq("sellerId", obj.getSellerId());
		if (!ObjectUtil.isEmpty(obj.getBuyerId()))
			q.addEq("buyerId", obj.getBuyerId());
		if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getCreartTimeBegin()))
				q.addGt("creartTime", obj.getCreartTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))
				q.addLt("creartTime", obj.getCreartTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()) && !ObjectUtil.isEmpty(obj.getPayTimeEnd())) {
			q.addBetween("payTime", obj.getPayTimeBegin(), obj.getPayTimeEnd());
		} else {
			if (!ObjectUtil.isEmpty(obj.getPayTimeBegin()))
				q.addGt("payTime", obj.getPayTimeBegin());
			if (!ObjectUtil.isEmpty(obj.getPayTimeEnd()))
				q.addLt("payTime", obj.getPayTimeEnd());
		}

		if (!ObjectUtil.isEmpty(obj.getState()))
			q.addEq("state", obj.getState());
		if (!ObjectUtil.isEmpty(obj.getAddress()))
			q.addEq("address", obj.getAddress());
		if (!ObjectUtil.isEmpty(obj.getIsSign()))
			q.addEq("isSign", obj.getIsSign());
		if (!ObjectUtil.isEmpty(obj.getIsPay()))
			q.addEq("isPay", obj.getIsPay());
		if (!ObjectUtil.isEmpty(obj.getLogisticsCode()))
			q.addEq("logisticsCode", obj.getLogisticsCode());
		String[] columnProperty = { "id", "commodityId", "pictureId", "price", "num", "sellerId", "buyerId",
				"creartTime", "payTime", "state", "address", "isSign", "isPay", "logisticsCode" };
		return this.findExpByQuery(q, columnProperty);
	}

}
