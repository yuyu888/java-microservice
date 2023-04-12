package com.myproject.testservice.api.logic;

import cn.hutool.core.date.DateUtil;
import com.myproject.testservice.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StreamDemoLogic {
    private List<PersonDto> initData(){
        List<PersonDto> personDtoList = new ArrayList<>();

        PersonDto personDto = new PersonDto();
        personDto.setUid(123);
        personDto.setName("miki");
        personDto.setAge(4);
        personDto.setBirthday(DateUtil.parse("2018-07-01"));
        personDto.setSex("female");
        personDto.setWeight(new BigDecimal(16.7));
        personDtoList.add(personDto);

        PersonDto personDto2 = new PersonDto();
        personDto2.setUid(137);
        personDto2.setName("rosie");
        personDto2.setAge(4);
        personDto2.setBirthday(DateUtil.parse("2018-05-12"));
        personDto2.setSex("female");
        personDto2.setWeight(new BigDecimal(14.3));
        personDtoList.add(personDto2);

        PersonDto personDto3 = new PersonDto();
        personDto3.setUid(146);
        personDto3.setName("stone");
        personDto3.setAge(5);
        personDto3.setBirthday(DateUtil.parse("2017-03-21"));
        personDto3.setSex("male");
        personDto3.setWeight(new BigDecimal(17.8));
        personDtoList.add(personDto3);

        PersonDto personDto4 = new PersonDto();
        personDto4.setUid(146);
        personDto4.setName("stone2");
        personDto4.setAge(5);
        personDto4.setBirthday(DateUtil.parse("2017-03-21"));
        personDto4.setSex("male");
        personDto4.setWeight(new BigDecimal(17.8));
        personDtoList.add(personDto4);
        return personDtoList;
    }

    public Map<String, PersonDto> listToMap(){
        List<PersonDto> personDtoList = initData();
        return personDtoList.stream().collect(Collectors.toMap(e->e.getName(), e->e));
//        return personList.stream().collect(Collectors.toMap(Person::getName, e->e));
    }

    public List<Integer> listToList() {
        List<PersonDto> personDtoList = initData();
        return personDtoList.stream().map(PersonDto::getUid).collect(Collectors.toList());
    }

    public long listCount() {
        List<PersonDto> personDtoList = initData();
        return personDtoList.stream().count();
    }

    public long listSumAge() {
        List<PersonDto> personDtoList = initData();
        return personDtoList.stream().mapToLong(PersonDto::getAge).sum();
    }

    public List<PersonDto>  listFilter() {
        List<PersonDto> personDtoList = initData();
        return  personDtoList.stream().filter(p->p.getSex().equals("male")).collect(Collectors.toList());
    }

    public List<PersonDto> mapToList() {
        List<PersonDto> personDtoList = initData();
        Map<String, PersonDto> personDtoMap =  personDtoList.stream().collect(Collectors.toMap(e->e.getName(), e->e));
//        personDtoMap.keySet().stream().collect(Collectors.toList());
        return personDtoMap.values().stream().collect(Collectors.toList());
    }

    public  List<String> listForeach() {
        List<PersonDto> personDtoList = initData();
        List<String> personDtoList2 = new ArrayList<>();
        personDtoList.stream().forEach(item->{
                    String sexShow = item.getSex()=="male"?"boy":"girl";
                    String message = item.getName()+"is a " + sexShow;
                    personDtoList2.add(message);
                }
        );
        return personDtoList2;
    }
}
