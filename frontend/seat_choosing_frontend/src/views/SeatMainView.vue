<template>
    <div>
        <!-- 下拉式選單選擇員工 -->
    <label>請選擇員工編號:
      <select v-model="selectedEmployee">
        <option v-for="employee in employees" :value="employee.empId" :key="employee.empId">{{ employee.empId }}</option>
      </select>
    </label>
  
      <div class="seat-table">
        <div
          v-for="seat in seats"
          :key="seat.floorSeatSEQ"
          :class="['seat', { 'occupied': seat.EmpID !== null, 'selected': selectedSeat === seat.floorSeatSEQ }]"
          @click="selectSeat(seat.floorSeatSEQ)"
        >
          <div>{{ seat.floorNO }}樓：座位{{ seat.seatNO }}</div>
          <div v-if="seat.EmpID !== null">[員編: {{ seat.EmpID }}]</div>
        </div>
      </div>
  
      <button @click="submitData">送出</button>
      <button @click="cancelSeat">清除座位</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'SeatMain',
    data() {
      return {
        employees: [],
        selectedEmployee: null,
        seats: [],
        selectedSeat: null,
      };
    },
    mounted() {
      this.getEmployees();
      this.getSeats();
    },
    methods: {
      getEmployees() {
        axios.get('http://localhost:8080/employee/all')
          .then(response => {
            this.employees = response.data;
          })
          .catch(error => {
            console.error(error);
          });
      },
      getSeats() {
        axios.get('http://localhost:8080/seat/all')
          .then(response => {
            this.seats = response.data;
          })
          .catch(error => {
            console.error(error);
          });
      },
      selectSeat(seatId) {
        this.selectedSeat = seatId;
        // if (!seat.EmpID) {
        //     this.selectedSeat = seat.floorSeatSEQ;
        // }
      },
      submitData() {
        if (!this.selectedEmployee || !this.selectedSeat) {
            // 若下拉式選單或座位未選擇，則不進行提交
            return;
        }
        const data = {
          EmpID: this.selectedEmployee,
          floorSeatSEQ: this.selectedSeat
        };
  
        axios.post('http://localhost:8080/employee/choosing', data)
          .then(response => {
            // 處理提交成功後的回應
            console.log(response.data);
            // 重新載入頁面
            location.reload();
          })
          .catch(error => {
            // 處理提交失敗的錯誤
            console.error(error);
          });
      },
      cancelSeat() {
        if (!this.selectedEmployee) {
            // 若下拉式選單未選擇，則不進行提交
            return;
        }
        const data = {
          EmpID: this.selectedEmployee,
          // floorSeatSEQ: this.selectedSeat
        };
  
        axios.post('http://localhost:8080/employee/cancel', data)
          .then(response => {
            // 處理提交成功後的回應
            console.log(response.data);
            // 重新載入頁面
            location.reload();
          })
          .catch(error => {
            // 處理提交失敗的錯誤
            console.error(error);
          });
      },
    },
  };
  </script>
  
  <style>
  .seat-table {
    /* display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-gap: 10px; */
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 10px;
  }
  
  .seat {
    width: 100px;
    height: 100px;
    border: 1px solid black;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    cursor: pointer;
  }
  
  .occupied {
    background-color: red;
    color: white;
    pointer-events: none;
  }
  
  .selected {
    background-color: green;
  }

  .unavailable {
    cursor: not-allowed;
  }

  button:disabled {
    opacity: 0.5;
    cursor: not-allowed;
  }
  </style>
  