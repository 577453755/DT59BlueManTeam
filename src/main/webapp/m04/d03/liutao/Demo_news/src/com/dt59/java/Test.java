package com.dt59.java;

import java.util.List;
import java.util.Scanner;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Info;

public class Test {

	/**
	 * ���ԣ������ֲ�󣬵�������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BizDao bizDao=new BizDaoImpl();//����ת��
		System.out.println("---------------------ԭʼ���ݣ�-----------------------");
		List<Info> list= bizDao.getAllInfo();
		for (Info ff : list) {
			System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
		}
		Scanner sc =new Scanner(System.in);
		System.out.println("--------------------------------------");
//		Info info=new Info();
//		System.out.println("������Ҫ�޸ĵı�ţ�");
//		info.setId(sc.nextInt());
//		System.out.println("������Ҫ�޸ĵ�����:");
//		info.setName(sc.next());
//		System.out.println("������Ҫ�޸ĵ����䣺");
//		info.setAge(sc.nextInt());
//		int flag=bizDao.updateInfo(info);
//		if(flag>0){
//			System.out.println("�޸ĳɹ���");
//		}else{
//			System.out.println("�޸�ʧ�ܣ�");
//		}
		System.out.println("������Ҫɾ���ı��:");
		int id=sc.nextInt();
		int flag= bizDao.deleteInfo(id);
		System.out.println("ɾ���Ľ����"+flag);
		System.out.println("=====================����ǣ�======================");
		List<Info> list2= bizDao.getAllInfo();
		for (Info ff : list2) {
			System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
		}
		
	}

}
