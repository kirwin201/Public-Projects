package com.kyleirwin;

import com.kyleirwin.dao.*;
import com.kyleirwin.model.Member;
import com.kyleirwin.model.Record;
import com.kyleirwin.model.Standing;
import com.kyleirwin.view.Menu;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.util.List;

public class SFL {

    private static final String MENU_DISPLAY_ALL_MEMBERS = "Display All SFL Members";
    private static final String MENU_DISPLAY_CURRENT_MEMBERS = "Display Current SFL Members";
    private static final String MENU_DISPLAY_RECORDS = "Display Member Records";
    private static final String MENU_LOOKUP_RECORD = "Lookup Record by Member ID";
    private static final String MENU_DISPLAY_STANDINGS = "Display Final Standing History";
    private static final String MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = new String[] {
            MENU_DISPLAY_ALL_MEMBERS,
            MENU_DISPLAY_CURRENT_MEMBERS,
            MENU_DISPLAY_RECORDS,
            MENU_LOOKUP_RECORD,
            MENU_DISPLAY_STANDINGS,
            MENU_OPTION_EXIT };

    private final Menu menu;
    private final MemberDao memberDao;
    private final RecordDao recordDao;
    private final StandingDao standingDao;

    public SFL(DataSource dataSource) {
        this.menu = new Menu(System.in, System.out);

        memberDao = new JdbcMemberDao(dataSource);
        recordDao = new JdbcRecordDao(dataSource);
        standingDao = new JdbcStandingDao(dataSource);
    }

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/SFL");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        SFL application = new SFL(dataSource);
        application.run();
    }

    private void run() {
        displayApplicationBanner();
        boolean running = true;
        while(running) {
            printHeading("Main Menu");
            String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if(choice.equals(MENU_DISPLAY_ALL_MEMBERS)) {
                handleMembers();
            } else if(choice.equals(MENU_DISPLAY_CURRENT_MEMBERS)) {
                handleCurrentMembers();
            }else if(choice.equals(MENU_DISPLAY_RECORDS)) {
                handleRecords();
            }else if(choice.equals(MENU_LOOKUP_RECORD)) {
                handleLookupRecord();
            } else if(choice.equals(MENU_DISPLAY_STANDINGS)) {
                handleSeasonStandings();
            } else if(choice.equals(MENU_OPTION_EXIT)) {
                running = false;
            }
        }
    }

    private void printHeading(String headingText) {
        System.out.println("\n"+headingText);
        for(int i = 0; i < headingText.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //SELECT 1
    private void handleMembers() {
        printHeading("All SFL Members");
        List<Member> allMembers = memberDao.getAllMembers();
        if(allMembers.size() > 0) {
            for(Member member : allMembers) {
                System.out.println(member.toString());
            }
        } else {
            System.out.println("\n*** No results ***");
        }
    }

    //SELECT 2
    private void handleCurrentMembers() {
        printHeading("All Current SFL Members");
        List<Member> allMembers = memberDao.getAllMembers();
        if(allMembers.size() > 0) {
            for(Member member : allMembers) {
                if (member.getIsCurrent())
                    System.out.println(member.toString());
                }
        } else {
            System.out.println("\n*** No results ***");
        }
    }

    //SELECT 3
    private void handleRecords() {
        printHeading("Member Records (Win-Loss-Draw)");
        List<Record> allRecords = recordDao.getAllRecords();
        if(allRecords.size() > 0) {
            for(Record record : allRecords) {
                Member member = memberDao.getMemberById(record.getMemberId());
                System.out.println(record.toString() + " = " + member.getTeamName());
            }
        } else {
            System.out.println("\n*** No results ***");
        }
    }

    //SELECT 4
    private void handleLookupRecord() {
        //NOT ACTIVE
    }
    //SELECT 5
    private void handleSeasonStandings() {
        printHeading("Final Season Standings");
        List<Standing> allStandings = standingDao.getStandings();
        if(allStandings.size() > 0) {
            for(Standing standing : allStandings) {
                Member firstMember = memberDao.getMemberById(standing.getFirst());
                Member secondMember = memberDao.getMemberById(standing.getSecond());
                Member thirdMember = memberDao.getMemberById(standing.getThird());
                Member fourthMember = memberDao.getMemberById(standing.getFourth());

                System.out.println(standing.getYear() +": " +
                        "\n\t 1st = " + firstMember.getMemberName() +
                        "\n\t 2nd = " + secondMember.getMemberName() +
                        "\n\t 3rd = " + thirdMember.getMemberName() +
                        "\n\t 4th = " + fourthMember.getMemberName());
            }
        }
        else {
            System.out.println("\n*** No results ***");
        }
    }

    private void displayApplicationBanner() {
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("          Welcome to the Super Football League                      ");
        System.out.println("********************************************************************");
    }

}
