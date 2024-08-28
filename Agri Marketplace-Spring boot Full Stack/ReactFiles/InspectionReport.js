import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Chart, registerables } from 'chart.js';
import { Bar } from 'react-chartjs-2';

// Register all necessary Chart.js components
Chart.register(...registerables);

const InspectionReport = () => {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('/api/inspection-report');
                const reportData = response.data;

                const chartData = {
                    labels: reportData.map(item => item.name),
                    datasets: [
                        {
                            label: 'Price',
                            data: reportData.map(item => item.price),
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderColor: 'rgba(75, 192, 192, 1)',
                            borderWidth: 1,
                        },
                        {
                            label: 'Quantity',
                            data: reportData.map(item => item.quantity),
                            backgroundColor: 'rgba(153, 102, 255, 0.2)',
                            borderColor: 'rgba(153, 102, 255, 1)',
                            borderWidth: 1,
                        },
                    ],
                };

                setData(chartData);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching inspection report data:', error);
            }
        };

        fetchData();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!data) {
        return <div>No data available</div>;
    }

    return (
        <div>
            <h2>Inspection Report</h2>
            <div style={{ width: '50%', height: '400px', margin: '0 auto' }}>
                <Bar data={data} />
            </div>
        </div>
    );
};

export default InspectionReport;
