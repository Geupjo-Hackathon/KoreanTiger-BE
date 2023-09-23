package com.geupjo.koreantiger;

import com.geupjo.koreantiger.entity.Class;
import com.geupjo.koreantiger.entity.*;
import com.geupjo.koreantiger.enums.Authority;
import com.geupjo.koreantiger.enums.LearningTimeGrade;
import com.geupjo.koreantiger.enums.StudentProfileTitle;
import com.geupjo.koreantiger.repository.*;
import com.geupjo.koreantiger.util.TimeUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.IntStream;

@ActiveProfiles("prod")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MockDataJobTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ClassInfoRepository classInfoRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private EducationProfileRepository educationProfileRepository;
    @Autowired
    private EducationHistoryRepository educationHistoryRepository;
    @Autowired
    private DetailedAnalysisRepository detailedAnalysisRepository;
    @Autowired
    private CodeBoxRepository codeBoxRepository;

    @Test
    @Commit
    void mockDataJob() {

    }

    @Test
    @Commit
    void mockTeacherJob() {
        // 7 명 (id 196 - 202)
        List<Member> teachers = List.of(
                new Member("이송화", Authority.TEACHER),
                new Member("김철수", Authority.TEACHER),
                new Member("유석배", Authority.TEACHER),
                new Member("한영희", Authority.TEACHER),
                new Member("김영수", Authority.TEACHER),
                new Member("이영희", Authority.TEACHER),
                new Member("유철수", Authority.TEACHER)
        );

        List<Member> saved = memberRepository.saveAll(teachers);
        System.out.println(saved.size());
        saved.forEach(member -> {
            System.out.println(member.toString());
        });
    }

    @Test
    @Commit
    void mockClassInfo() {
        // 10개 (id - 1 - 10)
        List<ClassInfo> classInfos = List.of(
                new ClassInfo("A반"),
                new ClassInfo("B반"),
                new ClassInfo("C반"),
                new ClassInfo("D반"),
                new ClassInfo("E반"),
                new ClassInfo("F반"),
                new ClassInfo("G반"),
                new ClassInfo("H반"),
                new ClassInfo("I반"),
                new ClassInfo("J반")
        );

        List<ClassInfo> saved = classInfoRepository.saveAll(classInfos);
        System.out.println(saved.size());
        saved.forEach(classInfo -> {
            System.out.println(classInfo.toString());
        });
    }

    @Test
    @Commit
    void mockInstitutionInfo() {
        // 3개 (id - 1 - 3)
        List<Institution> institutions = List.of(
                new Institution("호랑 초등학교", "001"),
                new Institution("호랑 중학교", "002"),
                new Institution("호랑 고등학교", "003")
        );

        List<Institution> saved = institutionRepository.saveAll(institutions);
        System.out.println(saved.size());
    }

    @Test
    @Commit
    void mockStudentJob() {
        // total 300 명
        // 60 명 (id 203 - 262) , teacherId 196, classInfoId 1, institutionId 1
        // 120 명 (id 263 - 382) , teacherId 196, classInfoId 2, institutionId 1
        // 60 명 (id 383 - 442) , teacherId 197, classInfoId 1, institutionId 2
        // 60 명 (id 443 - 502) , teacherId 198, classInfoId 1, institutionId 3

        List<Member> students = getStudentDummy();
        List<Member> saved = memberRepository.saveAll(students);

        System.out.println(saved.size());
        saved.forEach(student -> {
            Class studentClass = new Class(student.getId(), 198L, 1L, 3L);
            classRepository.save(studentClass);
        });
    }

    @Test
    @Commit
    void mockDetailedAnalysisJob() {
        // 300 개
        IntStream.range(203, 503)
                .forEach(i -> {
                    int grammar = (int) (Math.random() * 100);
                    int assignment = (int) (Math.random() * 100);
                    int algorithm = (int) (Math.random() * 100);
                    int recursive = (int) (Math.random() * 100);
                    int string = (int) (Math.random() * 100);
                    int total = (grammar + assignment + algorithm + recursive + string) / 5;

                    DetailedAnalysis detailedAnalysis = new DetailedAnalysis(grammar, assignment, algorithm, recursive, string, total, i);
                    DetailedAnalysis saved = detailedAnalysisRepository.save(detailedAnalysis);

                    System.out.println(saved.getId());
                });
    }

    @Test
    @Commit
    void mockLectureJob() {
        IntStream.range(203, 305)
                .forEach(i -> {
                    int progress1 = (int) (Math.random() * 100);
                    int progress2 = (int) (Math.random() * 100);
                    int progress3 = (int) (Math.random() * 100);

                    List<Lecture> lectures = List.of(
                            new Lecture("호랑 프로그래밍 기초", "001", progress1, i),
                            new Lecture("문자열 기초", "002", progress2, i),
                            new Lecture("호랑 문법", "003", progress3, i),
                            new Lecture("반복문", "004", progress3, i),
                            new Lecture("조건문", "005", progress3, i),
                            new Lecture("재귀", "006", progress3, i),
                            new Lecture("계산기 만들기", "007", progress3, i)
                    );
                    List<Lecture> saved = lectureRepository.saveAll(lectures);
                });
    }

    @Test
    @Commit
    void mockEducationProfileJob() {
        IntStream.range(203, 503)
                .forEach(i -> {
                    DetailedAnalysis detailedAnalysis = detailedAnalysisRepository.findByMemberId((long) i)
                            .orElseThrow(() -> new IllegalArgumentException("DetailedAnalysis Not Found"));

                    int experience = (int) (Math.random() * 100);
                    int level = (int) (Math.random() * 100);
                    String lastEducation = "https://www.askedtech.com/media/141049";
                    double progress = Math.random() * 100;
                    StudentProfileTitle studentProfileTitle;
                    if (progress > 90)
                        studentProfileTitle = StudentProfileTitle.MASTER;
                    else if (progress > 70)
                        studentProfileTitle = StudentProfileTitle.HIGH;
                    else if (progress > 50)
                        studentProfileTitle = StudentProfileTitle.MIDDLE;
                    else
                        studentProfileTitle = StudentProfileTitle.BASIC;

                    EducationProfile educationProfile = new EducationProfile(experience, level, i, detailedAnalysis.getId(), lastEducation, progress, studentProfileTitle);
                    EducationProfile saved = educationProfileRepository.save(educationProfile);

                    System.out.println(saved.getId());
                });
    }

    @Test
    @Commit
    void mockEducationHistoryJob() {
//        IntStream.range(1, 40)
//                .forEach(i -> {

        long memberId = 268;
        long totalLearningTime = makeRandomEpochMilli();
        long totalLearningTime1 = makeRandomEpochMilli();
        long totalLearningTime2 = makeRandomEpochMilli();
        long totalLearningTime3 = makeRandomEpochMilli();
        long totalLearningTime4 = makeRandomEpochMilli();
        long totalLearningTime5 = makeRandomEpochMilli();
        long totalLearningTime6 = makeRandomEpochMilli();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();

                    List<EducationHistory> educationHistories = List.of(
                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.SUNDAY))
                                    , totalLearningTime,
                                    getGrade(totalLearningTime),
                                    getEpochMilli(date.with(DayOfWeek.SUNDAY)
                                            .minusWeeks(5)), memberId),

                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.MONDAY))
                                    , totalLearningTime1,
                                    getGrade(totalLearningTime1),
                                    getEpochMilli(date.with(DayOfWeek.MONDAY)
                                            .minusWeeks(5)), memberId),

                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.TUESDAY))
                                    , totalLearningTime2,
                                    getGrade(totalLearningTime2),
                                    getEpochMilli(date.with(DayOfWeek.TUESDAY)
                                            .minusWeeks(5)), memberId),

                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.WEDNESDAY))
                                    , totalLearningTime3,
                                    getGrade(totalLearningTime3),
                                    getEpochMilli(date.with(DayOfWeek.WEDNESDAY)
                                            .minusWeeks(5)), memberId),

                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.THURSDAY))
                                    , totalLearningTime4,
                                    getGrade(totalLearningTime4),
                                    getEpochMilli(date.with(DayOfWeek.THURSDAY)
                                            .minusWeeks(5)), memberId),

                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.FRIDAY))
                                    , totalLearningTime5,
                                    getGrade(totalLearningTime5),
                                    getEpochMilli(date.with(DayOfWeek.FRIDAY)
                                            .minusWeeks(5)), memberId),

                            new EducationHistory(true, 0,
                                    getEpochMilli(dateTime.with(DayOfWeek.SATURDAY))
                                    , totalLearningTime6,
                                    getGrade(totalLearningTime6),
                                    getEpochMilli(date.with(DayOfWeek.SATURDAY)
                                            .minusWeeks(5)), memberId)
                    );

                    List<EducationHistory> saved = educationHistoryRepository.saveAll(educationHistories);
                    System.out.println(saved.size());
//                });
    }

    private static LearningTimeGrade getGrade(long totalLearningTime) {
        return LearningTimeGrade.convert(TimeUtils.EpochMilliToMinutes(totalLearningTime));
    }

    private long makeRandomEpochMilli() {
        int minutes = (int) (Math.random() * 300);
        return (long) minutes * (60 * 1000);
    }

    private long getEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    private long getEpochMilli(LocalDate localDate) {
        return localDate.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    private List<Member> getStudentDummy() {
        // 60 명
        return List.of(
                new Member("박인수", Authority.STUDENT),
                new Member("유재석", Authority.STUDENT),
                new Member("김종국", Authority.STUDENT),
                new Member("하하", Authority.STUDENT),
                new Member("정형돈", Authority.STUDENT),
                new Member("이광수", Authority.STUDENT),
                new Member("지석진", Authority.STUDENT),
                new Member("양세찬", Authority.STUDENT),
                new Member("김희철", Authority.STUDENT),
                new Member("김종민", Authority.STUDENT),
                new Member("이영자", Authority.STUDENT),
                new Member("이영희", Authority.STUDENT),
                new Member("이영수", Authority.STUDENT),
                new Member("이영철", Authority.STUDENT),
                new Member("이영민", Authority.STUDENT),
                new Member("지상철", Authority.STUDENT),
                new Member("지상민", Authority.STUDENT),
                new Member("지상희", Authority.STUDENT),
                new Member("지상자", Authority.STUDENT),
                new Member("이루리", Authority.STUDENT),
                new Member("이루미", Authority.STUDENT),
                new Member("백석훈", Authority.STUDENT),
                new Member("백석철", Authority.STUDENT),
                new Member("백석자", Authority.STUDENT),
                new Member("백석민", Authority.STUDENT),
                new Member("백석희", Authority.STUDENT),
                new Member("백석수", Authority.STUDENT),
                new Member("백석영", Authority.STUDENT),
                new Member("백석호", Authority.STUDENT),
                new Member("백석훈", Authority.STUDENT),
                new Member("백석철", Authority.STUDENT),
                new Member("지윤", Authority.STUDENT),
                new Member("유하영", Authority.STUDENT),
                new Member("유하진", Authority.STUDENT),
                new Member("유하민", Authority.STUDENT),
                new Member("유하희", Authority.STUDENT),
                new Member("유하수", Authority.STUDENT),
                new Member("오유민", Authority.STUDENT),
                new Member("오유진", Authority.STUDENT),
                new Member("오유영", Authority.STUDENT),
                new Member("오유자", Authority.STUDENT),
                new Member("오유수", Authority.STUDENT),
                new Member("오유희", Authority.STUDENT),
                new Member("오유철", Authority.STUDENT),
                new Member("오유호", Authority.STUDENT),
                new Member("유하진", Authority.STUDENT),
                new Member("이든", Authority.STUDENT),
                new Member("이온", Authority.STUDENT),
                new Member("신지수", Authority.STUDENT),
                new Member("신지희", Authority.STUDENT),
                new Member("신지민", Authority.STUDENT),
                new Member("신지영", Authority.STUDENT),
                new Member("신민수", Authority.STUDENT),
                new Member("신민희", Authority.STUDENT),
                new Member("신민진", Authority.STUDENT),
                new Member("신민영", Authority.STUDENT),
                new Member("유민석", Authority.STUDENT),
                new Member("유민수", Authority.STUDENT),
                new Member("유민희", Authority.STUDENT),
                new Member("유민진", Authority.STUDENT)
        );
    }
}
