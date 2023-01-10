import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react'
import { DataGrid, GridColDef, GridValueGetterParams } from '@mui/x-data-grid';

const columns: GridColDef[] = [
  { field: 'citizen', headerName: 'Citizen', type: 'boolean', width: 150 },
  { field: 'id', headerName: 'ID', width: 150 },
  { field: 'name', headerName: 'Name', width: 150 },
  { field: 'hasDrivingLicence', headerName: 'Has Driving License', type: 'boolean', width: 150 },
  {
    field: 'children',
    headerName: 'Children',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 460,
    valueGetter: (params: GridValueGetterParams) =>
        Object.keys(params.row.children || [] )

  },
];



function App() {
  const [tableData, setTableData] = useState([])

  useEffect(() => {
    fetch("http://localhost:8085/api/v1/citizen/findall")
        .then((data) => data.json())
        .then((data) => setTableData(data))

  }, [])

   console.log(tableData)

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
