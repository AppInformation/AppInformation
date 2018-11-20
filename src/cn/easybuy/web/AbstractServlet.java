package cn.easybuy.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���������ĺô����ǿ��԰�doget��dopost�������
 * @author DELL
 *
 */
public abstract class AbstractServlet extends HttpServlet {
	
	//����һ����������ĳ��󷽷�
	public abstract Class getServletClass();
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�����˸���ķ���������������");
		//��ǰ̨ҳ���ȡһ����������
		String name = request.getParameter("action");
		System.out.println(name);
		//������
		Method method = null;
		try {
			//��һ������˼����ͨ��getServletClass()������󷽷��õ���������ࡣȻ����ͨ��getDeclaredMethod()�õ���������Ҫִ�еķ���
			method = getServletClass().getDeclaredMethod(name, HttpServletRequest.class,HttpServletResponse.class);
			//��һ����ִ�з���
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			//���԰��쳣ҳ���������ת
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
