package com.hrms.service;

import java.util.List;

import com.hrms.entity.Position;
import com.hrms.page.Page;

public interface PositionService {
   
	/**
	 *��������ְλ
	 * @param position
	 * @return
	 */
	Boolean savePosition(Position position);
	/**
	 * ����ְλ
	 * @param position
	 * @return
	 */
	Boolean updatePosition(Position position);
	/**
	 * ɾ��ְλ
	 * @param position
	 * @return
	 */
	Boolean deletePosition(Position position);
	/**
	 * ��ѯȫ������ְλ
	 * @return
	 */
	List<Position> getPositions();
	
	/**
	 * ����������ѯְλ
	 * @param position
	 * @return
	 */
	List<Position> getPositions(Position position);
	List<Position> getPositions(Position position,Page page);
	/**
	 * ����id��ѯ����ְλ
	 * @param id
	 * @return
	 */
	Position getPosition(Position id);
}
