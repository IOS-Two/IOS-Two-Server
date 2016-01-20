package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class question
 */
@WebServlet("/question")
public class question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public question() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		String pathname = "/Users/jiangchenzhou/Desktop/IosService/question/" + date + ".txt";
		File file = new File(pathname);
		if (!file.exists()) {
			System.out.println("文件不存在");
			System.out.println(this.getClass().getResource("/").getPath());
		} else {
			JSONObject studentJSONObject = new JSONObject();
			Scanner input = new Scanner(file);
			String value = "";
			while (input.hasNextLine()) {
				String text = input.nextLine();
				System.out.println(text);

				value += text;

			}
			value = value.replace("\n","");
			studentJSONObject.put("name", "Jason");
			studentJSONObject.put("id", 20130001);
			studentJSONObject.put("phone", "13579246810");
			studentJSONObject.put("article", value);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().append(studentJSONObject.toString());
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
