package com.company.usertradersback.dto.user;

import com.company.usertradersback.entity.UserDepartmentEntity;
import com.company.usertradersback.entity.UserEntity;
import com.company.usertradersback.payload.Payload;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//회원 가입을 위한 회원 한명 전체 UserDto (requestDto) 및
//회원 한명 전체를 조회하기 위한 UserDto (responseDto)
public class UserDto {

    // 고정 페이로드
    private Payload payload;

    // 회원 고유번호
    private Integer id;

    // 회원 이메일
    private String email;

    // 회원 비밀번호
    private String password;

    // 회원 이름
    private String userName;

    // 회원 닉네임
    private String nickname;

    // 회원 학과 고유번호
    private UserDepartmentEntity departmentId;

    // 회원 학번
    private String studentId;

    // 회원 성별 0:남자,1:여자
    private Integer gender;

    // 회원 역활
    private List<String> roles = new ArrayList<>();

    // 회원 로그인 종류 0:일반,1:카카오
    private Integer loginType;

    // 회원 프로필 이미지
    private String imagePath;

    // 회원 등록 날짜
    private LocalDateTime createAt;

    // 회원 수정 날짜
    private LocalDateTime modifiedAt;

    @Builder
    public UserDto(Payload payload, Integer id, String email, String password, String userName, String nickname,
                   UserDepartmentEntity departmentId, String studentId,
                   Integer gender, List<String> roles, Integer loginType, String imagePath,
                   LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.payload =payload;
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.nickname = nickname;
        this.departmentId = departmentId;
        this.studentId = studentId;
        this.gender = gender;
        this.roles = roles;
        this.loginType = loginType;
        this.imagePath = imagePath;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }

    //회원 가입 정보 추가를 위한 UserDto -> UserEntity 변환
    // 그러나 안쓰고 직접 빌더 패턴을 이용하였다.
    public UserEntity convertDtoToEntity() {
        return UserEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .userName(userName)
                .nickname(nickname)
                .departmentId(departmentId)
                .studentId(studentId)
                .gender(gender)
                .roles(roles)
                .loginType(loginType)
                .imagePath(imagePath)
                .createAt(createAt)
                .modifiedAt(modifiedAt)
                .build();
    }

    //프로필 조회할 때 DB에서 꺼낸 전체 UserEntity -> UserDto 바꿈
    public UserDto UserEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .payload(null)
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .userName(userEntity.getUsername())
                .nickname(userEntity.getNickname())
                .departmentId(userEntity.getDepartmentId())
                .studentId(userEntity.getStudentId())
                .gender(userEntity.getGender())
                .roles(userEntity.getRoles())
                .loginType(userEntity.getLoginType())
                .imagePath(userEntity.getImagePath())
                .createAt(userEntity.getCreateAt())
                .modifiedAt(userEntity.getModifiedAt())
                .build();
    }


}