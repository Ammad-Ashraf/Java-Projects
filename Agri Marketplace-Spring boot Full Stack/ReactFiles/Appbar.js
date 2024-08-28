import * as React from 'react';
import { Link as RouterLink } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';

export default function Appbar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Cropify-Agri MarketPlace
          </Typography>
          {/* Add navigation links */}
          <Button color="inherit" component={RouterLink} to="/">Home</Button>
          <Button color="inherit" component={RouterLink} to="/commodities">Commodities</Button>
          <Button color="inherit" component={RouterLink} to="/offers">Offers</Button>
          <Button color="inherit" component={RouterLink} to="/users">Users</Button>
          <Button color="inherit" component={RouterLink} to="/orders">Orders</Button>
          <Button color="inherit" component={RouterLink} to="/inspection-report">Inspection Report</Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
