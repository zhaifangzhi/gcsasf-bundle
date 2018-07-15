package com.deletetask;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.databasemodel.UserService;
import com.findrenamefile.Renamelmp;
import com.model.BotService;
import com.model.UrlService;
import com.pojos.SteamUser;

@Component
public class DeleteTask {
	
	public static int i=14;
	public static String kl="/mnt/_dl/";
	
	@Autowired
	private UserService us;
	
	@Autowired
	private JDBCservice js;
	
	@Autowired
	private BotService bs;
	
	@Autowired
	private UrlService uc;
	
	@Autowired
	private Renamelmp rl;
	
	@Scheduled(fixedRate=10800000)
    public void work() throws Exception {
		long currenttime=System.currentTimeMillis();
		if(us.getAllSteamUsers()!=null){
            BigInteger a=new BigInteger("2592000000");
            BigInteger b=new BigInteger("7776000000");
            BigInteger c=new BigInteger("15552000000");
            BigInteger d=new BigInteger("31104000000");
			List<SteamUser> lsu=us.getAllSteamUsers();
			for(int i=0;i<lsu.size();i++){
				BigInteger k=new BigInteger(""+currenttime);
				BigInteger l=new BigInteger(""+lsu.get(i).getStarttime());
				BigInteger f=new BigInteger(k.subtract(l)+"");
				if((!((f.subtract(a)+"").startsWith("-")))&&(lsu.get(i).getAuthority().equals("[ROLE_a]"))){
					bs.deleteBot(lsu.get(i).getUsername());
					js.delete(lsu.get(i).getSystemusername());
				}else if((!((f.subtract(b)+"").startsWith("-")))&&(lsu.get(i).getAuthority().equals("[ROLE_b]"))){
					bs.deleteBot(lsu.get(i).getUsername());
					js.delete(lsu.get(i).getSystemusername());
				}else if((!((f.subtract(c)+"").startsWith("-")))&&(lsu.get(i).getAuthority().equals("[ROLE_c]"))){
					bs.deleteBot(lsu.get(i).getUsername());
					js.delete(lsu.get(i).getSystemusername());
				}else if((!((f.subtract(d)+"").startsWith("-")))&&(lsu.get(i).getAuthority().equals("[ROLE_d]"))){
					bs.deleteBot(lsu.get(i).getUsername());
					js.delete(lsu.get(i).getSystemusername());
				}
			}
	}
	System.out.println("do some work");
}
	
	//此项为给自己steam号不断变化玩的游戏，给自己300左右steam好友起展示作用
	@Scheduled(fixedRate=5000)
	public void fun(){
           i++;
           String[] b={"730","304390","374320","227300","105600","4000",
        		   "105600","236850","201270",
        		   "211820","278080","113200","310560","322330","207140"};
           if(i>2000000000){
        	   i=i-1900000000;
           }
           try {
			uc.play(us.getFromSystemuser("zhaifangzhi"), b[i%15]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
	
	//重命名，方便文件往gcs转移
	@Scheduled(fixedRate=20000)
	public void renameFile(){
		rl.rename(kl);
	}
}
