package cn.easybuy.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这样子做的好处就是可以把doget和dopost抽象出来
 * @author DELL
 *
 */
public abstract class AbstractServlet extends HttpServlet {
	
	//定义一个返回子类的抽象方法
	public abstract Class getServletClass();
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入了父类的方法。。。。。。");
		//从前台页面获取一个方法名称
		String name = request.getParameter("action");
		System.out.println(name);
		//方法类
		Method method = null;
		try {
			//这一步的意思，是通过getServletClass()这个抽象方法拿到具体的子类。然后在通过getDeclaredMethod()拿到子类你想要执行的方法
			method = getServletClass().getDeclaredMethod(name, HttpServletRequest.class,HttpServletResponse.class);
			//这一步是执行方法
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			//可以把异常页面从这里跳转
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
