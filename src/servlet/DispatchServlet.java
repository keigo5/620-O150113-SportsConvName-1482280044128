package servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.InfoBean;

/*
 * タイトル：サーブレット
 * 説明    ：サーブレットです。
 */

@WebServlet({  "/home"})
public class DispatchServlet extends HttpServlet {

    /* serialVersionUID */
    private static final long serialVersionUID = 1L;

    /* スポーツファイル(infile.csv)の格納パス */
    private static final String FILE_PATH = "/WEB-INF/data/sports_list.csv";

    /* CSVファイル スポーツ名(カナ)の列番号 */
    private static final int KANA_COLUMN = 1;

    /* CSVファイル スポーツ名(漢字)の列番号 */
    private static final int KANJI_COLUMN = 0;

    /* CSVファイル スポーツ人数の列番号 */
    private static final int PLAYER_COLUMN = 2;

    /* キーワード受け取り用のキー値 */
    private static final String KEYWORD_KEY = "keyword";

    /**
     * デフォルトコンストラクタ
     */
    public DispatchServlet() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());

        // TODO Auto-generated method stub
        RequestDispatcher view = request.getRequestDispatcher(path + ".jsp");
        view.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath(FILE_PATH);
        String keyword = request.getParameter(KEYWORD_KEY);
        InfoBean info = new InfoBean();
        try{
            //ファイルを開くためのインスタンスを生成
            FileReader fr = new FileReader(realPath);

            //FileReaderだと効率が悪いのでBufferedReaderを使用
            BufferedReader br = new BufferedReader(fr);
            try {
                /* csvより読み込んだ一行を保持 */
                String tmp;

                /* 一行のうち、列の項目ごとに値を保持 */
                StringTokenizer stk;

                /* /読み込んだ値を保持 */
                ArrayList<String> strData = new ArrayList<String>();

                /* 列数を保持 */
                int num;

                //一行ずつ読み込み、抽出処理を行う
                while (br.ready()) {
                    strData.clear();
                    tmp = br.readLine();
                    stk = new StringTokenizer(tmp, "\t");
                    num = stk.countTokens();

                    //列の項目を読み込み、値を保持する
                    for (int i = 0; i < num; i++) {
                        strData.add(stk.nextToken());
                    }

                    //値が読み込まれていれば、キーワードと項目を比較する
                    if (!strData.isEmpty() && keyword.equals(strData.get(KANA_COLUMN))) {
                        //一致した行のデータをbeanに詰め込む
                        info.setSportsKana(strData.get(KANA_COLUMN));
                        info.setSportsKanji(strData.get(KANJI_COLUMN));
                        info.setSportsPlayers(strData.get(PLAYER_COLUMN));
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //検索結果をjson形式に変換
        ObjectMapper mapper = new ObjectMapper();
        String retJson = mapper.writeValueAsString(info);

        //画面へ書き出し
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(retJson);
    }

}