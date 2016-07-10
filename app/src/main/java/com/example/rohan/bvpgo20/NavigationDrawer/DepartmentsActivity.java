package com.example.rohan.bvpgo20.NavigationDrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohan.bvpgo20.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DepartmentsActivity extends AppCompatActivity {

    BottomBar mBottomBar;

    ImageView HODImageView;
    TextView tvHODName;
    TextView tvHODEmail;
    TextView tvAboutUs;
    TextView tvVision;
    TextView tvMission;
    TextView tvFromTheDeskOfHOD;
    TextView tvFullForm;

    ArrayList<String> aboutUs;
    ArrayList<String> vision;
    ArrayList<String> mission;
    ArrayList<String> HODImage;
    ArrayList<String> HODName;
    ArrayList<String> HODEmailID;
    ArrayList<String> fromTheDeskOfHOD;
    ArrayList<String> fullForms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        setTitle("Departments");

        aboutUs = new ArrayList<>();
        vision = new ArrayList<>();
        mission = new ArrayList<>();
        HODImage = new ArrayList<>();
        HODName = new ArrayList<>();
        HODEmailID = new ArrayList<>();
        fromTheDeskOfHOD = new ArrayList<>();
        fullForms = new ArrayList<>();

        HODImageView = (ImageView) findViewById(R.id.HODImage);
        tvHODName = (TextView) findViewById(R.id.HODName);
        tvHODEmail = (TextView) findViewById(R.id.HODEmail);
        tvAboutUs = (TextView) findViewById(R.id.aboutUs);
        tvVision = (TextView) findViewById(R.id.vision);
        tvMission = (TextView) findViewById(R.id.mission);
        tvFromTheDeskOfHOD = (TextView) findViewById(R.id.fromTheDeskOfHOD);
        tvFullForm = (TextView) findViewById(R.id.fullForm);

        mBottomBar = BottomBar.attach(this, savedInstanceState);

        HODImage.add("http://bvcoend.ac.in/images/upload/BVPFILE95481198301967FILE25456UPLOAD5377329.jpg");
        HODImage.add("http://bvcoend.ac.in/images/upload/BVP_Bharati_Vidyapeeths_College_of_Engineering_,New_Delhi_99703183906739FILE55454UPLOAD87179661455775561.png");
        HODImage.add("http://bvcoend.ac.in/images/upload/BVP_Bharati_Vidyapeeths_College_of_Engineering_,New_Delhi_88385901792423FILE51144UPLOAD73630351435636294.jpg");
        HODImage.add("http://bvcoend.ac.in/images/upload/BVP_Bharati_Vidyapeeths_College_of_Engineering_,New_Delhi_48857166923979FILE4138UPLOAD16026541454052542.png");
        HODImage.add("http://bvcoend.ac.in/images/upload/BVP_Bharati_Vidyapeeths_College_of_Engineering_,New_Delhi_24480592145357FILE98290UPLOAD85996171426582677.jpg");

        HODName.add("Dr. Bindu Garg ");
        HODName.add("Dr. Vanita Jain");
        HODName.add("Dr. Anuradha Basu ");
        HODName.add("Prof. Kusum Tharani");
        HODName.add("Mrs. Aarti Kane");

        fullForms.add("Computer Science and Engineering");
        fullForms.add("Information Technology");
        fullForms.add("Electronics and Communication Engineering");
        fullForms.add("Electrical and Electronics Engineering");
        fullForms.add("Instrumentation and Control Engineering");

        HODEmailID.add("bindu.garg@bharatividyapeeth.edu");
        HODEmailID.add("vanita.jain@bharatividyapeeth.edu");
        HODEmailID.add("anuradha.basu@bharatividyapeeth.edu");
        HODEmailID.add("kusum.tharani@bharatividyapeeth.edu");
        HODEmailID.add("arati.kane@bharatividyapeeth.edu");

        aboutUs.add("Faculty is highly qualified, dedicated and always willing to work for continuous improvement and growth of students. Faculty is student centered. As the admission process is merit based so high rank holding students prefer to take admission in the CSE department. We have a strong desire among both faculty and administration for graduate education to be a growth area.");
        aboutUs.add("Bharati vidyapeeth’s college of engg., New Delhi since its establishment in 1999, has strived to provide the best engineering education to its students through well qualified and dedicated faculty and provision of well equipped modern labs.");
        aboutUs.add("The Department of Electronics and Communication Engineering is the largest department of BVCOE in terms of number of faculty and number of student intake with 180 students taking admission each year. Running in both the morning as well as evening shifts, the department is proud to have highly trained and qualified faculty members dedicated towards the cause of imparting good quality education.");
        aboutUs.add("Faculty is highly qualified, dedicated and always willing to work for continuous improvement and growth of students. Faculty is student centered. As the admission process is merit based so high rank holding students prefer to take admission in the EEE department. We have a strong desire among both faculty and administration for graduate education to be a growth area.");
        aboutUs.add("Instrumentation and Control Engineering is a multidisciplinary stream and it covers the major aspects of chemical, mechanical, electrical and electronics fundamentals.Instrumentation and control engineering includes the core subjects.");

        vision.add("We aspire to be the leader in the country in the field of Technical education and research involving Computer Science and Engineering to produce globally competent professionals contributing to maintain India’s elite position on the globe.");
        vision.add("To impart Quality Education, to give an enviable growth to seekers of knowledge, to groom them as World Class IT Engineers by imbibing spiritual values and technical excellence, making them competent to match the expanding expectations.");
        vision.add("We strive towards being the leaders in practical education of various fields in Electronics and Communication Engineering as well as to inculcate good moral values to produce quality engineers and responsible members of the society.");
        vision.add("To excel in engineering education and research, inculcating professional ethics in students and emerge as a leaders in the country in the field of electrical & electronics engineering.");
        vision.add("To excel in automation & all advance technologies related to process industry, health sector for the welfare of the society and encourage and support creative and innovative projects & activities.");

        mission.add("To impart quality education to the students and to create an innovative research environment for both faculty and students along with inculcating professional behavior and strong ethical values in accordance with the best practices in the world .");
        mission.add("Our mission is to seek solutions to important global problems and educate leaders who will make the world a better place by using the power of engineering principles, techniques and systems.");
        mission.add("Our department stands on three pillars that are held in high esteem – practical education, well qualified teachers and a disciplined environment.Our mission is to inculcate moral and ethical values to our students while affording good opportunities for practical learning and creating a research environment.We aim towards graduating professionals who can take responsibility of themselves as well as the society.");
        mission.add("Empowering students and professionals with state-of-art knowledge and Technological skills. Understand the basic principles of modern electrical & electronics technology. Are able to apply their knowledge to solve problems arising in whatever career path they choose. Are sensitive to societal issues and are committed to professional ethics.");
        mission.add("Instrumentation and Control has grown into a pioneer sector for research in instrumentation in India. Department aims to impart quality technical education and to conduct research to meet the growing needs of the industry and society.");

        fromTheDeskOfHOD.add("The objective of Department of Computer Science and Engineering is imparting quality education in the field of Computer Science and technology. With rapidly evolving technology and the continuous need for innovation the department has always produced quality professionals, holding important positions in Information Technology research and industry in India and abroad.\n" +
                "\n" +
                "The Department has well equipped laboratories with latest technology computer systems and software. Each laboratory is equipped with more than twenty (as per students practical batch size) Desktop Machines, with one server and a laser printer. The laboratories are fully networked and provide all facilities to the student to take their projects and research works. The department has provided WIFI connection to all the students to get online academic resources for their overall excellence.");
        fromTheDeskOfHOD.add("\"Innovation distinguishes between a leader and a follower.\" -Steve Jobs\n" +
                "\n" +
                "Learning is a continuous and endless process and does not finish with the acquisition of a degree, especially because steady and rapid advances in Computing Technologies shorten the life of tools and techniques prevalent today. Right from its inception, the Information Technology Department has been offering excellent infrastructural & teaching facilities with a variety of computing platforms to aspiring professional students to meet the burgeoning demands of the IT industry. Therefore, we give our students a strong foundation in IT, problem solving techniques and make them adaptable to changes. The prime endeavor of the department is to produce confident professionals tuned to real time working environment. Students at IT Department are nurtured to become best software professionals or entrepreneurs in their own innovative way. The department offers excellent academic environment with a team of highly qualified faculty members to inspire the students to develop their technical skills and inculcate the spirit of team work in them.");
        fromTheDeskOfHOD.add("The department aims to impart quality technical education to the students, who are aspiring either for a professional career in the field of Electronics and Communications Engineering or pursuing higher education in their choice of fields. They are rigorously trained to enrich them with the fundamental facts and principles of the core technologies in their discipline. This department owes its foundation to primarily three factors, namely, well-trained teachers, a disciplined atmosphere and fairly equipped labs. Also, a dedicated team of staff members enhance the ambience for both faculty and students, to pursue their research interests in the preferred field of study.");
        fromTheDeskOfHOD.add("The process of learning is extremely important in life. What you learn, how you learn and where you learn play a crucial role in developing ones intellectual capability, besides career. Hence on behalf of Department of Electrical and Electronics, I welcome all you to BVCOE New Delhi. Along with academic knowledge BVCOE also trains its Technocrats to face the challenges in life by providing many value added courses to enhance their career prospects. The excellent infrastructure, teaching faculty of the best kind ensuring quality education such as interaction among students, parents and staff, along with a Training and Placement Cell ensures a bright future to its students. Electrical and Electronics engineering continues to be an ever demanding in industry as indicated by the current trend for hiring graduates. Electrical and electronics engineers are working today in all spheres of modern society, be it internet, cellular communication, satellites, industrial control systems, power systems, non conventional energy sources or DC and AC transmission systems. The curriculum of the department of electrical and electronics engineering is therefore designed to impart the students consummate knowledge and skills for careers in wide range of industries. The department boasts of distinguished and dedicated faculty that offers full support to the students to help bring out the best in them. Moreover, the faculty members organize special sessions for topics related to their individual areas of interest so that students get familiarized with the state of the art happenings in the domain of EEE.");
        fromTheDeskOfHOD.add("Instrumentation and Control Engineering deals with measurement, control and automation of industrial and research processes. It is a multidisciplinary field and plays a vital role in all industries and research organizations.\n" + "Instrumentation and Control Engineering department of Bharati Vidyapeeth's College of Engineering, with its team of qualified and dedicated faculties, is committed to develop instrumentation professionals with a progressive attitude and the most updated skill-sets to match the academic and industry needs. We have state-of-the-art lab facilities to enhance the core competency of the students complimented with industry collaboration. We truly strive to achieve the motto of creating an ambience of overall development and academic excellence for the prospective engineers.");

//        mBottomBar.useFixedMode();
        mBottomBar.setMaxFixedTabs(4);

        mBottomBar.setItems(
                new BottomBarTab(R.drawable.ic_home_black_18dp, "CSE"),
                new BottomBarTab(R.drawable.ic_home_black_18dp, "IT"),
                new BottomBarTab(R.drawable.ic_home_black_18dp, "ECE"),
                new BottomBarTab(R.drawable.ic_home_black_18dp, "EEE"),
                new BottomBarTab(R.drawable.ic_home_black_18dp, "ICE")
        );

        mBottomBar.mapColorForTab(0, "#6488a8");
        mBottomBar.mapColorForTab(1, "#e43f4d");
        mBottomBar.mapColorForTab(2, "#2372b2");
        mBottomBar.mapColorForTab(3, "#c65b08");
        mBottomBar.mapColorForTab(4, "#442a42");


        mBottomBar.setOnTabClickListener(new OnTabClickListener() {

                                             @Override
                                             public void onTabSelected(int position) {
//                                                  The user selected a tab at the specified position
                                                 if (position == 0) {
                                                     cse();
                                                 }
                                                 if (position == 1) {
                                                     it();
                                                 }
                                                 if (position == 2) {
                                                     ece();
                                                 }
                                                 if (position == 3) {
                                                     eee();
                                                 }
                                                 if (position == 4) {
                                                     ice();
                                                 }

                                             }

                                             @Override
                                             public void onTabReSelected(int position) {
//                                                  The user reselected a tab at the specified position!
                                                 if (position == 0) {
                                                     cse();
                                                 }
                                                 if (position == 1) {
                                                     it();
                                                 }
                                                 if (position == 2) {
                                                     ece();
                                                 }
                                                 if (position == 3) {
                                                     eee();
                                                 }
                                                 if (position == 4) {
                                                     ice();
                                                 }

                                             }
                                         }
        );

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    public void cse() {
        Picasso.with(DepartmentsActivity.this).load(HODImage.get(0)).into(HODImageView);
        tvHODName.setText(HODName.get(0));
        tvHODEmail.setText(HODEmailID.get(0));
        tvAboutUs.setText(aboutUs.get(0));
        tvVision.setText(vision.get(0));
        tvMission.setText(mission.get(0));
        tvFromTheDeskOfHOD.setText(fromTheDeskOfHOD.get(0));
        tvFullForm.setText(fullForms.get(0));
    }

    public void it() {
        Picasso.with(DepartmentsActivity.this).load(HODImage.get(1)).into(HODImageView);
        tvHODName.setText(HODName.get(1));
        tvHODEmail.setText(HODEmailID.get(1));
        tvAboutUs.setText(aboutUs.get(1));
        tvVision.setText(vision.get(1));
        tvMission.setText(mission.get(1));
        tvFromTheDeskOfHOD.setText(fromTheDeskOfHOD.get(1));
        tvFullForm.setText(fullForms.get(1));
    }

    public void ece() {
        Picasso.with(DepartmentsActivity.this).load(HODImage.get(2)).into(HODImageView);
        tvHODName.setText(HODName.get(2));
        tvHODEmail.setText(HODEmailID.get(2));
        tvAboutUs.setText(aboutUs.get(2));
        tvVision.setText(vision.get(2));
        tvMission.setText(mission.get(2));
        tvFromTheDeskOfHOD.setText(fromTheDeskOfHOD.get(2));
        tvFullForm.setText(fullForms.get(2));
    }

    public void eee() {
        Picasso.with(DepartmentsActivity.this).load(HODImage.get(3)).into(HODImageView);
        tvHODName.setText(HODName.get(3));
        tvHODEmail.setText(HODEmailID.get(3));
        tvAboutUs.setText(aboutUs.get(3));
        tvVision.setText(vision.get(3));
        tvMission.setText(mission.get(3));
        tvFromTheDeskOfHOD.setText(fromTheDeskOfHOD.get(4));
        tvFullForm.setText(fullForms.get(3));
    }

    public void ice() {
        Picasso.with(DepartmentsActivity.this).load(HODImage.get(4)).into(HODImageView);
        tvHODName.setText(HODName.get(4));
        tvHODEmail.setText(HODEmailID.get(4));
        tvAboutUs.setText(aboutUs.get(4));
        tvVision.setText(vision.get(4));
        tvMission.setText(mission.get(4));
        tvFromTheDeskOfHOD.setText(fromTheDeskOfHOD.get(4));
        tvFullForm.setText(fullForms.get(4));
    }
}
