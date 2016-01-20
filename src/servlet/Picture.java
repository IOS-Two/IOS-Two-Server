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
 * Servlet implementation class Picture
 */
@WebServlet("/Picture")
public class Picture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Picture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		String reco = request.getParameter("who");
		String pathname = "/Users/jiangchenzhou/Desktop/IosService/picture/" + date + reco + ".txt";
		File file = new File(pathname);
		if (!file.exists()) {
			System.out.println("文件不存在");
			System.out.println(this.getClass().getResource("/").getPath());
		} else {
			JSONObject PictureJSONObject = new JSONObject();
			Scanner input = new Scanner(file);
			String value = "";
			String url = input.nextLine();
			String author = input.nextLine();
			while (input.hasNextLine()) {
				String text = input.nextLine();
				System.out.println(text);

				value += text;

			}
			//value = value.replace("\n","");
			PictureJSONObject.put("url", url);
			if (reco.equals("j"))
				PictureJSONObject.put("recommender", "JCZ");
			else 
				PictureJSONObject.put("recommender", "GZF");
			PictureJSONObject.put("author", author);
			PictureJSONObject.put("describtion", value);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().append(PictureJSONObject.toString());
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
