package com.hrms.service;

import java.util.List;

import com.hrms.entity.Position;

public interface PositionService {
   
	/**
	 *保存所有职位
	 * @param position
	 * @return
	 */
	Boolean savePosition(Position position);
	/**
	 * 更新职位
	 * @param position
	 * @return
	 */
	Boolean updatePosition(Position position);
	/**
	 * 删除职位
	 * @param position
	 * @return
	 */
	Boolean deletePosition(Position position);
	/**
	 * 查询全部所有职位
	 * @return
	 */
	List<Position> getPositions();
	/**
	 * 根据条件查询职位
	 * @param position
	 * @return
	 */
	List<Position> getPositions(Position position);
	/**
	 * 根据id查询单个职位
	 * @param id
	 * @return
	 */
	Position getPosition(Position id);
}
