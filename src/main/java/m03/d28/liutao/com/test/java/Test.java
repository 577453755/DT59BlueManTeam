/**
 * Project Name:study
 * File Name:Test.java
 * Package Name:com.test.java
 * Date:2018��3��28������11:13:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.java;

import java.util.List;
import java.util.Scanner;

import com.test.dao.QuestionInfoDao;
import com.test.dao.impl.QuestionInfoDaoImpl;
import com.test.entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018��3��28�� ����11:13:56 <br/>
 * @author   liutao
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {

        QuestionInfoDao qid=new QuestionInfoDaoImpl();//��̬����ת��
        System.out.println("*****************************��ӭʹ���������ϵͳ***********************************");
        System.out.print("��ѡ�����(1.�г��������� 2.����Ŀ��ѯ 3.�����ģ����ѯ 4.������� 5.ɾ������ 6.�˳�ϵͳ):");
        Scanner sca=new Scanner(System.in);
        int num=sca.nextInt();
        switch (num) {
        case 1:
            List<QuestionInfo> list=qid.getAllQuery();
            for (QuestionInfo questionInfo : list) {
                System.out.println(questionInfo.getQuestionId()+"��"+questionInfo.getQuestion()+"\n\t"
                        +"ѡ��A:"+questionInfo.getOptionA()+"\n\t"
                        +"ѡ��B:"+questionInfo.getOptionB()+"\n\t"
                        +"ѡ��C:"+questionInfo.getOptionC()+"\n\t"
                        +"ѡ��D:"+questionInfo.getOptionD()+"\n\t"
                        +"��:"+questionInfo.getAnswer()
                        );                
            }           
            break;
        case 2:
            System.out.print("�������Ŀ:(1.Java 2.C# 3.JSP):");
            int n=sca.nextInt();
            List<QuestionInfo> list2=qid.getSubject(n);
            for (QuestionInfo questionInfo : list2) {
                System.out.println(questionInfo.getQuestionId()+"��"+questionInfo.getQuestion()+"\n\t"
                        +"ѡ��A:"+questionInfo.getOptionA()+"\n\t"
                        +"ѡ��B:"+questionInfo.getOptionB()+"\n\t"
                        +"ѡ��C:"+questionInfo.getOptionC()+"\n\t"
                        +"ѡ��D:"+questionInfo.getOptionD()+"\n\t"
                        +"��:"+questionInfo.getAnswer()
                        );                
            } 
            break;
        case 3:
            System.out.print("���������:");
            String name=sca.next();
            List<QuestionInfo> list3=qid.getLike(name);
            for (QuestionInfo questionInfo : list3) {
                System.out.println(questionInfo.getQuestionId()+"��"+questionInfo.getQuestion()+"\n\t"
                        +"ѡ��A:"+questionInfo.getOptionA()+"\n\t"
                        +"ѡ��B:"+questionInfo.getOptionB()+"\n\t"
                        +"ѡ��C:"+questionInfo.getOptionC()+"\n\t"
                        +"ѡ��D:"+questionInfo.getOptionD()+"\n\t"
                        +"��:"+questionInfo.getAnswer()
                        );                
            } 
    
            break;
    
        case 4:
            QuestionInfo ff=new QuestionInfo();
            System.out.print("�������Ŀ:(1.Java 2.C# 3.JSP):");
            ff.setSubject(sca.nextInt());
            System.out.print("�������µ����:");
            ff.setQuestion(sca.next());
            System.out.print("�������µ�ѡ��A:");
            ff.setOptionA(sca.next());
            System.out.print("�������µ�ѡ��B:");
            ff.setOptionB(sca.next());
            System.out.print("�������µ�ѡ��C:");
            ff.setOptionC(sca.next());
            System.out.print("�������µ�ѡ��D:");
            ff.setOptionD(sca.next());
            System.out.print("�������µĴ�:");
            ff.setAnswer(sca.next());
            int flag=qid.updataInfo(ff);
            if(flag>0){
                System.out.println("��ӳɹ���");
            }else{
                System.out.println("���ʧ�ܣ�");
            }
    
            break;
        case 5:
            while(true){
            System.out.print("�������ĿҪɾ����������:");
            int dd=sca.nextInt();
            flag=qid.deleteInfo(dd);
            if(flag>0){
                System.out.println("ɾ���ɹ���");
                break;
            }else{
                System.out.println("�Բ���û��Ҫɾ���ı�ţ�,����������");
            }
            }
            
            break;
        case 6:
            System.out.println("ϵͳ�˳��ɹ���");
            
            break;

        default:
            break;
        }
       
        sca.close();
    }
    

}

