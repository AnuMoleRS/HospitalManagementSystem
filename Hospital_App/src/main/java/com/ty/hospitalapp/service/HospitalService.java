package com.ty.hospitalapp.service;

import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		Hospital hospital1 = hospitalDaoImp.saveHospital(hospital);
		if (hospital1 != null) {
			System.out.println("data saved");
		}
		else
			System.out.println("no data saved");
	}

	public Hospital getHospitalById(int hid) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		Hospital hospital1 = hospitalDaoImp.getHospitalById(hid);
		if (hospital1 != null) {
			return hospital1;
		}
		else
			return null;
	}

	public void deleteHospitalById(int hid) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		boolean flag = hospitalDaoImp.deleteHospitalById(hid);
		if (flag) {
			System.out.println("data deleted");
		}
		else
			System.out.println("data not deleted");
	}

	public Hospital updateHospitalById(int hid, Hospital hospital) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		Hospital hospital1 = hospitalDaoImp.updateHospitalById(hid, hospital);
		if (hospital1 != null) {
			return hospital1;
		}
		else
			return null;
	}
}
