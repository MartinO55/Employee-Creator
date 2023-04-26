type Employee = {
  id: string;
  firstName: string;
  middleName: string | null;
  lastName: string;
  email: string;
  phoneNumber: string;
  contractType: string;
  createdAt: string;
  startDate: string;
  endDate: string | null;
};

export default Employee;
