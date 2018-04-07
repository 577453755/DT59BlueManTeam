/**
 * Project Name:study
 * File Name:QuestionInfoDao.java
 * Package Name:com.test.dao
 * Date:2018��3��28������4:18:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao;

import java.util.List;

import com.test.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018��3��28�� ����4:18:09 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    // 1.��ѯ����
    List<QuestionInfo> getAllQuery();

    // 2.��ѯ��Ŀ
    List<QuestionInfo> getsubject(int num);

    // 3.���ģ����ѯ
    List<QuestionInfo> getLike(String str);

    // 4.�������
    int uppdata(T t);

    // 5.ɾ������
    int delete(int questionId);

    // ���ô洢���̲�ѯ����ѯ��������
    List<QuestionInfo> callprodedure();

    // ���ô洢����,�����ģ����ѯ
    List<QuestionInfo> callprocedure2(String str);

    // �˳�ϵͳ

}
