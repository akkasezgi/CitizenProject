import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react'
import { DataGrid, GridColDef, GridValueGetterParams } from '@mui/x-data-grid';

const columns: GridColDef[] = [
  { field: 'isCitizen', headerName: 'Citizen', type: 'boolean', width: 70 },
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'Name', headerName: 'Name', width: 130 },
  { field: 'hasDrivingLicense', headerName: 'Has Driving License', type: 'boolean', width: 70 },
  {
    field: 'Children',
    headerName: 'Children',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 460,
    valueGetter: (params: GridValueGetterParams) =>
        // Object.keys(params.row.Children)

        `${Object.keys(params.row.Children) || 'qq'}`,
  },
];

const rows1 = [
  {
    "isCitizen": true,
    "Name": "John Smith",
    "id": 123456,
    "Children": {
      "Mike Smith": 123457,
      "Jessica Smith": 123458,
      "Sarah Smith": 123459
    },
    "hasDrivingLicense": true
  },
  {
    "isCitizen": false,
    "Name": "Michael Tall",
    "id": 123461,
    "Children": {
    },
    "hasDrivingLicense": false
  },
  {
    "isCitizen": false,
    "Name": "Joe Bloggs",
    "id": 123462,
    "Children": {
      "Sarah Bloggs": 123463
    },
    "hasDrivingLicense": true
  }
];

function App() {
  const [tableData, setTableData] = useState([])

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
        .then((data) => data.json())
        .then((data) => setTableData(data))

  }, [])

  // console.log(tableData)

  return (
      <div style={{ height: 700, width: '100%' }}>
        <DataGrid
            rows={rows1}
            columns={columns}
            pageSize={10}
            rowsPerPageOptions={[10]}
        />
      </div>
  );
}

export default App;
