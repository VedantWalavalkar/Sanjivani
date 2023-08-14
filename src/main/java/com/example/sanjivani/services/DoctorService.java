package com.example.sanjivani.services;

import com.example.sanjivani.DTO.RequestDTO.AddDoctorRequest;
import com.example.sanjivani.DTO.ResponseDTO.AddDoctorResponse;
import com.example.sanjivani.exception.VacinationCenterNotFoundException;
import com.example.sanjivani.model.Doctor;
import com.example.sanjivani.model.VacinationCenter;
import com.example.sanjivani.repository.DoctorRepository;
import com.example.sanjivani.repository.VacinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VacinationCenterRepository vacinationCenterRepository;
    public AddDoctorResponse addDoctor(AddDoctorRequest addDoctorRequest){
        Doctor doctor = new Doctor();
        doctor.setAge(addDoctorRequest.getAge());
        doctor.setName(addDoctorRequest.getName());
        doctor.setEmailId(addDoctorRequest.getEmailId());
        doctor.setGender(addDoctorRequest.getGender());
        Optional<VacinationCenter> optionalVacinationCenter = vacinationCenterRepository.findById(addDoctorRequest.getVacinationCenterId());
        if(optionalVacinationCenter.isEmpty())
            throw new VacinationCenterNotFoundException("Invalid Center Id");
        VacinationCenter vacinationCenter = optionalVacinationCenter.get();
        doctor.setVacinationCenter(vacinationCenter);
        vacinationCenter.getDoctorList().add(doctor);

        VacinationCenter savedVacinationCenter = vacinationCenterRepository.save(vacinationCenter);

        List<Doctor> doctorList = savedVacinationCenter.getDoctorList();
        Doctor savedDoctor = doctorList.get(doctorList.size() - 1);

        AddDoctorResponse addDoctorResponse = new AddDoctorResponse();
        addDoctorResponse.setId(savedDoctor.getId());
        addDoctorResponse.setName(savedDoctor.getName());
        addDoctorResponse.setEmailId(savedDoctor.getEmailId());

        return addDoctorResponse;
    }
}
