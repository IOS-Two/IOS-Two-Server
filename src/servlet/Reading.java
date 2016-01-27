package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

/**
 * Servlet implementation class Reading
 */
@WebServlet("/Reading")
public class Reading extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reading() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub、
		String date = request.getParameter("date");
		String reco = request.getParameter("who");
		String pathname = "/Users/jiangchenzhou/Desktop/IosService/Reading/" + date + reco + ".txt";
		System.out.println(pathname);
		File file = new File(pathname);
		if (!file.exists()) {
			System.out.println("文件不存在");
			System.out.println(this.getClass().getResource("/").getPath());
		} else {
			JSONObject studentJSONObject = new JSONObject();
			Scanner input = new Scanner(file);
			String value = "";
			String title = input.nextLine();
			String author = input.nextLine();
			while (input.hasNextLine()) {
				String text = input.nextLine();
				//System.out.println(text);
				value += text;

			}
			value = value.replace("\n","");
			studentJSONObject.put("author", author);
			studentJSONObject.put("title", title);
			studentJSONObject.put("recommder", "");
			studentJSONObject.put("article", value);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().append(studentJSONObject.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
