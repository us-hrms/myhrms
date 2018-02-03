package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Certificate;

public interface CertificateService {
	/**
	 * 更新
	 * @param certificate
	 * @return
	 */
	Boolean updateCertificate(Certificate certificate);
	
	/**
	 * 删除
	 * @param certificate
	 */
	Boolean deleteCertificate(Certificate certificate);
	
	/**
	 * 根据id获得一个Certificate对象
	 */
	Certificate getCertificate(Serializable id);
	
	/**
	 * 获得所有的certificate对象
	 * @return
	 */
	List<Certificate> getCertificates();
	
	/**
	 * 按条件查询certificate
	 * @param certificate
	 * @return
	 */
	List<Certificate> getCertificates(Certificate certificate);
}
