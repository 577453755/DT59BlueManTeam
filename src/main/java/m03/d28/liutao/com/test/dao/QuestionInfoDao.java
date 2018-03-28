/**
 * Project Name:study
 * File Name:QuestionInfoDao.java
 * Package Name:com.test.dao
 * Date:2018��3��28������10:53:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao;

import java.util.List;
import com.test.entity.QuestionInfo;






/**
 * Description:   <br/>
 * Date:     2018��3��28�� ����10:53:14 <br/>
 * @author   liutao
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    //1.��ѯ����
    List<QuestionInfo> getAllQuery();
    //2.���ݿ�Ŀ��ѯ
    List<QuestionInfo> getSubject(int nu);
    //3.ģ����ѯ
    List<QuestionInfo> getLike(String str);
    //4.����µ�����
     int updataInfo(T t);
     //5.ɾ��
     int deleteInfo(int dd);

}

