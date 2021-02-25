<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" v-on:change="toggleSelect" v-model="selectAll" id="selectAll" />
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Disabled">Disabled</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ disabled: user.status === 'Disabled' }"
        >
          <td>
            <input v-on:change="updateSelectAll" type="checkbox" v-model="selectedUserIDs"  v-bind:id="user.id" v-bind:value="user.id" />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button v-on:click="flipStatus(user.id)" class="btnEnableDisable">{{user.status === 'Active'?'Disable':'Enable'}}</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button v-on:click="enableSelectedUsers" :disabled="actionButtonDisabled">Enable Users</button>
      <button v-on:click="disableSelectedUsers" :disabled="actionButtonDisabled">Disable Users</button>
      <button v-on:click="deleteSelectedUsers" :disabled="actionButtonDisabled">Delete Users</button>
    </div>

    <button v-on:click="show">Add New User</button>

    <form v-on:submit.prevent="saveUser" v-show="showForm" id="frmAddNewUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input v-model="newUser.firstName" type="text" name="firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input v-model="newUser.lastName" type="text" name="lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input v-model="newUser.username" type="text" name="username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input v-model="newUser.emailAddress" type="text" name="emailAddress" />
      </div>
      <button v-on:click="hide" type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      showForm: false,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      selectAll: false,
      selectedUserIDs: [],
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled"
        }
      ]
    };
  },
  methods: {
    show() {
      this.showForm = true;
    },
    hide() {
      this.showForm = false;
    },
    clear() {
      this.newUser = {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      }
    },
    clearChecked() {
      this.selectedUserIDs = [];
    },
    saveUser() {
      if (Object.values(this.newUser).every(prop => prop !== '')) {
        this.users.unshift(this.newUser);
      }
      
       
      this.clear();
    },
    flipStatus(id) {
      let user = this.users.find(user => user.id === id);
      user.status = user.status === 'Active'?'Disabled':'Active';
    },
    enableSelectedUsers() {
      this.selectedUserIDs.forEach(id => {
        let user = this.users.find(user => user.id === id);
        user.status = 'Active';
      });
      this.clearChecked();
    },
    disableSelectedUsers() {
      this.selectedUserIDs.forEach(id => {
        let user = this.users.find(user => user.id === id);
        user.status = 'Disabled';
      });
      this.clearChecked();
    },
    deleteSelectedUsers() {
      this.selectedUserIDs.forEach(id => {
        this.users.splice(this.users.findIndex(user => user.id === id), 1);
      });
      this.clearChecked();
    },
    toggleSelect() {
      if (this.selectAll) {
        this.users.forEach(user => {
          if (!this.selectedUserIDs.includes(user.id)) {
            this.selectedUserIDs.push(user.id);
          }
        })
      }else {
        this.selectedUserIDs = [];
      }
    },
    updateSelectAll() {
      this.selectAll = this.selectedUserIDs.length === this.users.length;
    }
  },
  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    },
    actionButtonDisabled() {
      return this.selectedUserIDs.length === 0;
    }
  }
}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
