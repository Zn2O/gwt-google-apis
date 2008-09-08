/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.maps.sample.hellomaps.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.InfoWindow;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapType;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.MapTypeControl;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.event.InfoWindowCloseClickHandler;
import com.google.gwt.maps.client.event.InfoWindowMaximizeClickHandler;
import com.google.gwt.maps.client.event.InfoWindowMaximizeEndHandler;
import com.google.gwt.maps.client.event.InfoWindowRestoreClickHandler;
import com.google.gwt.maps.client.event.InfoWindowRestoreEndHandler;
import com.google.gwt.maps.client.event.MapAddMapTypeHandler;
import com.google.gwt.maps.client.event.MapAddOverlayHandler;
import com.google.gwt.maps.client.event.MapClearOverlaysHandler;
import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.event.MapDoubleClickHandler;
import com.google.gwt.maps.client.event.MapDragEndHandler;
import com.google.gwt.maps.client.event.MapDragHandler;
import com.google.gwt.maps.client.event.MapDragStartHandler;
import com.google.gwt.maps.client.event.MapInfoWindowBeforeCloseHandler;
import com.google.gwt.maps.client.event.MapInfoWindowCloseHandler;
import com.google.gwt.maps.client.event.MapInfoWindowOpenHandler;
import com.google.gwt.maps.client.event.MapMouseMoveHandler;
import com.google.gwt.maps.client.event.MapMouseOutHandler;
import com.google.gwt.maps.client.event.MapMouseOverHandler;
import com.google.gwt.maps.client.event.MapMoveEndHandler;
import com.google.gwt.maps.client.event.MapMoveHandler;
import com.google.gwt.maps.client.event.MapMoveStartHandler;
import com.google.gwt.maps.client.event.MapRemoveMapTypeHandler;
import com.google.gwt.maps.client.event.MapRemoveOverlayHandler;
import com.google.gwt.maps.client.event.MapRightClickHandler;
import com.google.gwt.maps.client.event.MapTypeChangedHandler;
import com.google.gwt.maps.client.event.MapZoomEndHandler;
import com.google.gwt.maps.client.event.MarkerClickHandler;
import com.google.gwt.maps.client.event.MarkerDoubleClickHandler;
import com.google.gwt.maps.client.event.MarkerDragEndHandler;
import com.google.gwt.maps.client.event.MarkerDragHandler;
import com.google.gwt.maps.client.event.MarkerDragStartHandler;
import com.google.gwt.maps.client.event.MarkerInfoWindowBeforeCloseHandler;
import com.google.gwt.maps.client.event.MarkerInfoWindowCloseHandler;
import com.google.gwt.maps.client.event.MarkerInfoWindowOpenHandler;
import com.google.gwt.maps.client.event.MarkerMouseDownHandler;
import com.google.gwt.maps.client.event.MarkerMouseOutHandler;
import com.google.gwt.maps.client.event.MarkerMouseOverHandler;
import com.google.gwt.maps.client.event.MarkerMouseUpHandler;
import com.google.gwt.maps.client.event.MarkerRemoveHandler;
import com.google.gwt.maps.client.event.MarkerVisibilityChangedHandler;
import com.google.gwt.maps.client.event.PolygonClickHandler;
import com.google.gwt.maps.client.event.PolygonRemoveHandler;
import com.google.gwt.maps.client.event.PolygonVisibilityChangedHandler;
import com.google.gwt.maps.client.event.PolylineClickHandler;
import com.google.gwt.maps.client.event.PolylineRemoveHandler;
import com.google.gwt.maps.client.event.PolylineVisibilityChangedHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geom.LatLngBounds;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.google.gwt.maps.client.overlay.Polygon;
import com.google.gwt.maps.client.overlay.Polyline;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * In this example, the different types of events that can be attached to a map
 * are demonstrated.
 */
public class MapEventDemo extends MapsDemo {

  // EOL Comments added to fix Eclipse automatic formatting
  private enum HandlerActions {
    INFO_WINDOW_CLOSE_CLICK_HANDLER("InfoWindowCloseClickHandler"), //
    INFO_WINDOW_MAXIMIZE_CLICK_HANDLER("InfoWindowMaximizeClickHandler"), //
    INFO_WINDOW_MAXIMIZE_END_HANDLER("InfoWindowMaximizeEndHandler"), //
    INFO_WINDOW_RESTORE_CLICK_HANDLER("InfoWindowRestoreClickHandler"), //
    INFO_WINDOW_RESTORE_END_HANDLER("InfoWindowRestoreEndHandler"), //
    MAP_ADD_MAP_TYPE_HANDLER("MapAddMapTypeHandler"), // //
    MAP_ADD_OVERLAY_HANDLER("MapAddOverlayHandler"), //
    MAP_CLEAR_OVERLAYS_HANDLER("MapClearOverlaysHandler"), //
    MAP_CLICK_HANDLER("MapClickHandler"), //
    MAP_DOUBLE_CLICK_HANDLER("MapDoubleClickHandler"), //
    MAP_DRAG_END_HANDLER("MapDragEndHandler"), //
    MAP_DRAG_HANDLER("MapDragHandler"), //
    MAP_DRAG_START_HANDLER("MapDragStartHandler"), // 
    MAP_INFO_WINDOW_BEFORE_CLOSE_HANDLER("MapInfoWindowBeforeCloseHandler"), //
    MAP_INFO_WINDOW_CLOSE_HANDLER("MapInfoWindowCloseHandler"), //
    MAP_INFO_WINDOW_OPEN_HANDLER("MapInfoWindowOpenHandler"), //
    MAP_MOUSE_MOVE_HANDLER("MapMouseMoveHandler"), //
    MAP_MOUSE_OUT_HANDLER("MapMouseOutHandler"), //
    MAP_MOUSE_OVER_HANDLER("MapMouseOverHandler"), //
    MAP_MOVE_END_HANDLER("MapMoveEndHandler"), //
    MAP_MOVE_HANDLER("MapMoveHandler"), //
    MAP_MOVE_START_HANDLER("MapMoveStartHandler"), //
    MAP_REMOVE_MAP_TYPE_HANDLER("MapRemoveMapTypeHandler"), //
    MAP_REMOVE_OVERLAY_HANDLER("MapRemoveOverlayHandler"), //
    MAP_RIGHT_CLICK_HANDLER("MapRightClickHandler"), //
    MAP_TYPE_CHANGED_HANDLER("MapTypeChangedHandler"), //
    MAP_ZOOM_END_HANDLER("MapZoomEndHandler"), //
    MARKER_CLICK_HANDLER("MarkerClickHandler"), //
    MARKER_DOUBLE_CLICK_HANDLER("MarkerDoubleClickHandler"), //
    MARKER_DRAG_END_HANDLER("MarkerDragEndHandler"), //
    MARKER_DRAG_HANDLER("MarkerDragHandler"), //
    MARKER_DRAG_START_HANDLER("MarkerDragStartHandler"), //
    MARKER_INFO_WINDOW_BEFORECLOSE_HANDLER("MarkerInfoWindowBeforeCloseHandler"), //
    MARKER_INFO_WINDOW_CLOSE_HANDLER("MarkerInfoWindowCloseHandler"), //
    MARKER_INFO_WINDOW_OPEN_HANDLER("MarkerInfoWindowOpenHandler"), //
    MARKER_MOUSE_DOWN_HANDLER("MarkerMouseDownHandler"), //
    MARKER_MOUSE_OUT_HANDLER("MarkerMouseOutHandler"), //
    MARKER_MOUSE_OVER_HANDLER("MarkerMouseOverHandler"), //
    MARKER_MOUSE_UP_HANDLER("MarkerMouseUpHandler"), //
    MARKER_REMOVE_HANDLER("MarkerRemoveHandler"), //
    MARKER_VISIBILITY_CHANGED_HANDLER("MarkerVisibilityChangedHandler"), //
    POLYGON_CLICK_HANDLER("PolygonClickHandler"), //
    POLYGON_REMOVE_HANDLER("PolygonRemoveHandler"), //
    POLYGON_VISIBILITY_CHANGED_HANDLER("PolygonVisibilityChangedHandler"), //
    POLYLINE_CLICK_HANDLER("PolylineClickHandler"), //
    POLYLINE_REMOVE_HANDLER("PolylineRemoveHandler"), //
    POLYLINE_VISIBILITY_CHANGED_HANDLER("PolylineVisibilityChangedHandler"); //

    private final String value;

    private HandlerActions(String s) {
      value = s;
    }

    public String valueOf() {
      return value;
    }
  }

  private static final LatLng ATLANTA = new LatLng(33.7814790, -84.3880580);
  private static LatLng[] ATLANTA_TRIANGLE1 = new LatLng[4];
  private static LatLng[] ATLANTA_TRIANGLE2 = new LatLng[4];

  private static HTML descHTML = null;

  private static final String descString = ""
      + "<p>Creates a 500 x  300 pixel map viewport centered on "
      + "Atlanta, GA USA.</p>\n"
      + "<p>Displays a draggable marker and various controls to exercise "
      + "event handling.</p>\n"
      + "<ul>\n <li><b>Hide/Show Marker</b> button alternately hides and "
      + "shows the marker which triggers the MarkerVisibilityListener.</li>\n"
      + " <li><b>Remove/Add Marker</b> button alternately removes and adds "
      + "the marker to the map which triggers the removeListener.</li>\n"
      + " <li><b>Enable/Disable Dragging</b> turns dragging on and off "
      + "on the marker.  Dragging must be enabled to trigger the DragListener.</li>\n"
      + " <li><b>Clear Table</b> Remove all entries from the table below.</li>\n"
      + " <li><b>Add Listener</b> Adds a listener of the type "
      + "specified in the listbox.  This will create a new entry in the table "
      + "to monitor and control the listener.</li>\n"
      + " <li><b>Clear Listeners of this Type</b> Clears all listeners of the"
      + "  type specified in the listbox.</li>\n"
      + "</ul>"
      + "<p>Below the action buttons there is a table of all listeners that "
      + "  have been added.  Each entry contains the following items:</p>\n"
      + "<ul>\n"
      + "<li><b>ID</b> A unique ID for each listener.</li>\n"
      + "<li><b>Type</b> The type of listener.</li>\n"
      + "<li><b>Events</b> A textbox that shows events as they happen.</li>"
      + "<li><b>Clear Text</b> A button that clears the <b>Events</b> textbox.</li>"
      + "<li><b>Remove Listener</b> Remove this specific listener instance."
      + "</ul>\n";

  // A unique number assigned to each new listener added.
  private static int listenerId = 0;

  public static MapsDemoInfo init() {
    return new MapsDemoInfo() {
      @Override
      public MapsDemo createInstance() {
        return new MapEventDemo();
      }

      @Override
      public HTML getDescriptionHTML() {
        if (descHTML == null) {
          descHTML = new HTML(descString);
        }
        return descHTML;
      }

      @Override
      public String getName() {
        return "Map Event Handlers";
      }
    };
  }

  private FlexTable handlerTable;

  private MapWidget map;
  // Saves the state of whether the sky map type has been removed.
  private boolean mapTypeRemoved = false;
  private Marker marker;
  // Saves the state of whether the maker is currently removed from the map
  private boolean markerRemoved = false;

  private Polygon polygon;
  // Saves the state of whether the polygon is currently removed from the map
  private boolean polygonRemoved = true;
  private Polyline polyline;
  // Saves the state of whether the polyline is currently removed from the map
  private boolean polylineRemoved = true;
  private boolean firstTime = true;

  public MapEventDemo() {
    VerticalPanel vp = new VerticalPanel();

    // Center the new map on Midtown Atlanta
    map = new MapWidget(ATLANTA, 13);
    map.setSize("500px", "300px");
    map.addControl(new SmallMapControl());
    map.addControl(new MapTypeControl());

    MarkerOptions opt = MarkerOptions.newInstance();
    opt.setDraggable(true);
    marker = new Marker(ATLANTA, opt);

    Panel hp1 = createActionButtons();

    HorizontalPanel hp2 = createListenerListBox();

    // Make a spacer
    HorizontalPanel hp3 = new HorizontalPanel();
    hp3.add(new Label(" "));
    hp3.setSize("1em", "1em");

    handlerTable = new FlexTable();
    clearListenerTable();

    vp.add(map);
    vp.add(hp1);
    vp.add(hp2);
    vp.add(hp3);
    vp.add(handlerTable);

    initWidget(vp);
  }

  @Override
  public void onShow() {
    map.addOverlay(marker);
    if (firstTime) {
      computeAtlantaTriangle();
      polygon = new Polygon(ATLANTA_TRIANGLE1);
      polyline = new Polyline(ATLANTA_TRIANGLE2);
      firstTime = false;
    }
  }

  private void addListenerToMarker(HandlerActions a) {
    // Create a unique ID for this new listener.
    final int nextListenerId = ++listenerId;

    // Create a new row to add to the UI.
    final int rowNumber = handlerTable.getRowCount();
    handlerTable.setWidget(rowNumber, 0, new Label("" + nextListenerId));
    handlerTable.setWidget(rowNumber, 1, new Label(a.valueOf()));

    final TextBox textBox = new TextBox();
    textBox.setReadOnly(true);
    textBox.setSize("30em", "1em");
    handlerTable.setWidget(rowNumber, 3, textBox);

    Button clearButton = new Button("Clear Text");
    clearButton.addClickListener(new ClickListener() {

      public void onClick(Widget sender) {
        textBox.setText("");
      }

    });
    handlerTable.setWidget(rowNumber, 4, clearButton);

    Button removeHandlerButton = new Button("Remove Handler");
    handlerTable.setWidget(rowNumber, 5, removeHandlerButton);

    // Add event specific handlers
    switch (a) {
      case INFO_WINDOW_CLOSE_CLICK_HANDLER: {
        final InfoWindowCloseClickHandler h = new InfoWindowCloseClickHandler() {

          public void onCloseClick(InfoWindowCloseClickEvent event) {
            textBox.setText(textBox.getText() + "onCloseClick()");
          }

        };
        map.getInfoWindow().addInfoWindowCloseClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.getInfoWindow().removeInfoWindowCloseClickHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case INFO_WINDOW_MAXIMIZE_CLICK_HANDLER: {
        final InfoWindowMaximizeClickHandler h = new InfoWindowMaximizeClickHandler() {

          public void onMaximizeClick(InfoWindowMaximizeClickEvent event) {
            textBox.setText(textBox.getText() + "onMaximizeClick()");
          }

        };
        map.getInfoWindow().addInfoWindowMaximizeClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.getInfoWindow().removeInfoWindowMaximizeClickHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case INFO_WINDOW_MAXIMIZE_END_HANDLER: {
        final InfoWindowMaximizeEndHandler h = new InfoWindowMaximizeEndHandler() {

          public void onMaximizeEnd(InfoWindowMaximizeEndEvent event) {
            textBox.setText(textBox.getText() + "onMaximizeEnd()");
          }

        };
        map.getInfoWindow().addInfoWindowMaximizeEndHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.getInfoWindow().removeInfoWindowMaximizeEndHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case INFO_WINDOW_RESTORE_CLICK_HANDLER: {
        final InfoWindowRestoreClickHandler h = new InfoWindowRestoreClickHandler() {

          public void onRestoreClick(InfoWindowRestoreClickEvent event) {
            textBox.setText(textBox.getText() + "onRestoreClick()");
          }

        };
        map.getInfoWindow().addInfoWindowRestoreClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.getInfoWindow().removeInfoWindowRestoreClickHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case INFO_WINDOW_RESTORE_END_HANDLER: {
        final InfoWindowRestoreEndHandler h = new InfoWindowRestoreEndHandler() {

          public void onRestoreEnd(InfoWindowRestoreEndEvent event) {
            textBox.setText(textBox.getText() + "onRestoreEnd()");
          }

        };
        map.getInfoWindow().addInfoWindowRestoreEndHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.getInfoWindow().removeInfoWindowRestoreEndHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_INFO_WINDOW_BEFORE_CLOSE_HANDLER: {
        final MapInfoWindowBeforeCloseHandler h = new MapInfoWindowBeforeCloseHandler() {

          public void onInfoWindowBeforeClose(
              MapInfoWindowBeforeCloseEvent event) {
            textBox.setText(textBox.getText() + "onInfoWindowBeforeClose()");
          }

        };

        map.addInfoWindowBeforeCloseHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeInfoWindowBeforeCloseHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_INFO_WINDOW_CLOSE_HANDLER: {
        final MapInfoWindowCloseHandler h = new MapInfoWindowCloseHandler() {

          public void onInfoWindowClose(MapInfoWindowCloseEvent event) {
            textBox.setText(textBox.getText() + "onInfoWindowClose()");
          }

        };

        map.addInfoWindowCloseHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeInfoWindowCloseHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_INFO_WINDOW_OPEN_HANDLER: {
        final MapInfoWindowOpenHandler h = new MapInfoWindowOpenHandler() {

          public void onInfoWindowOpen(MapInfoWindowOpenEvent event) {
            textBox.setText(textBox.getText() + "onInfoWindowOpen()");
          }

        };

        map.addInfoWindowOpenHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeInfoWindowOpenHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_CLEAR_OVERLAYS_HANDLER: {
        final MapClearOverlaysHandler h = new MapClearOverlaysHandler() {

          public void onClearOverlays(MapClearOverlaysEvent event) {
            textBox.setText(textBox.getText() + "onClearOverlays()");
          }

        };

        map.addMapClearOverlaysHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapClearOverlaysHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_ADD_MAP_TYPE_HANDLER: {
        final MapAddMapTypeHandler h = new MapAddMapTypeHandler() {

          public void onAddMapType(MapAddMapTypeEvent event) {
            textBox.setText(textBox.getText() + "onAddMapType("
                + event.getType().getName(true) + ")");
          }

        };

        map.addMapAddMapTypeHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapAddMapTypeHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_ADD_OVERLAY_HANDLER: {
        final MapAddOverlayHandler h = new MapAddOverlayHandler() {

          public void onAddOverlay(MapAddOverlayEvent event) {
            textBox.setText(textBox.getText() + "onAddOverlay("
                + event.getOverlay() + ")");
          }

        };

        map.addMapAddOverlayHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapAddOverlayHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_CLICK_HANDLER: {
        final MapClickHandler h = new MapClickHandler() {

          public void onClick(MapClickEvent e) {
            textBox.setText(textBox.getText() + "onClick(" + e.getLatLng()
                + ")");
          }

        };
        map.addMapClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapClickHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_DOUBLE_CLICK_HANDLER: {
        final MapDoubleClickHandler h = new MapDoubleClickHandler() {

          public void onDoubleClick(MapDoubleClickEvent e) {
            textBox.setText(textBox.getText() + "onDoubleClick("
                + e.getLatLng() + ")");
          }
        };
        map.addMapDoubleClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapDoubleClickHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_DRAG_END_HANDLER: {
        final MapDragEndHandler h = new MapDragEndHandler() {

          public void onDragEnd(MapDragEndEvent event) {
            textBox.setText(textBox.getText() + "onDragEnd()");
          }

        };

        map.addMapDragEndHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapDragEndHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;
      case MAP_DRAG_HANDLER: {
        final MapDragHandler h = new MapDragHandler() {

          public void onDrag(MapDragEvent event) {
            textBox.setText(textBox.getText() + "onDrag()");
          }

        };

        map.addMapDragHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapDragHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_DRAG_START_HANDLER: {
        final MapDragStartHandler h = new MapDragStartHandler() {

          public void onDragStart(MapDragStartEvent event) {
            textBox.setText(textBox.getText() + "onDragStart()");
          }

        };

        map.addMapDragStartHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapDragStartHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_MOUSE_OUT_HANDLER: {
        final MapMouseOutHandler h = new MapMouseOutHandler() {

          public void onMouseOut(MapMouseOutEvent event) {
            textBox.setText(textBox.getText() + "onMouseOut("
                + event.getLatLng() + ")");
          }

        };

        map.addMapMouseOutHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapMouseOutHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_MOUSE_OVER_HANDLER: {
        final MapMouseOverHandler h = new MapMouseOverHandler() {

          public void onMouseOver(MapMouseOverEvent event) {
            textBox.setText(textBox.getText() + "onMouseOver("
                + event.getLatLng() + ")");
          }

        };

        map.addMapMouseOverHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapMouseOverHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;

      case MAP_MOUSE_MOVE_HANDLER: {
        final MapMouseMoveHandler h = new MapMouseMoveHandler() {

          public void onMouseMove(MapMouseMoveEvent event) {
            textBox.setText(textBox.getText() + "onMouseMove("
                + event.getLatLng() + ")");
          }
        };
        map.addMapMouseMoveHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapMouseMoveHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_MOVE_END_HANDLER: {
        final MapMoveEndHandler h = new MapMoveEndHandler() {

          public void onMoveEnd(MapMoveEndEvent e) {
            textBox.setText(textBox.getText() + "onMoveEnd()");
          }
        };
        map.addMapMoveEndHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapMoveEndHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_MOVE_HANDLER: {
        final MapMoveHandler h = new MapMoveHandler() {

          public void onMove(MapMoveEvent e) {
            textBox.setText(textBox.getText() + "onMove()");
          }
        };
        map.addMapMoveHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapMoveHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_MOVE_START_HANDLER: {
        final MapMoveStartHandler h = new MapMoveStartHandler() {

          public void onMoveStart(MapMoveStartEvent e) {
            textBox.setText(textBox.getText() + "onMoveStart()");
          }
        };
        map.addMapMoveStartHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapMoveStartHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_REMOVE_MAP_TYPE_HANDLER: {
        final MapRemoveMapTypeHandler h = new MapRemoveMapTypeHandler() {

          public void onRemoveMapType(MapRemoveMapTypeEvent event) {
            textBox.setText(textBox.getText() + "onRemoveMapType("
                + event.getType().getName(true) + ")");
          }

        };

        map.addMapRemoveMapTypeHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapRemoveMapTypeHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;
      case MAP_REMOVE_OVERLAY_HANDLER: {
        final MapRemoveOverlayHandler h = new MapRemoveOverlayHandler() {

          public void onRemoveOverlay(MapRemoveOverlayEvent event) {
            textBox.setText(textBox.getText() + "onRemoveOverlay("
                + event.getOverlay().toString() + ")");
          }

        };

        map.addMapRemoveOverlayHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            map.removeMapRemoveOverlayHandler(h);
            // removeRowFromTable(nextListenerId);
          }

        });
      }
        break;
      case MAP_RIGHT_CLICK_HANDLER: {
        final MapRightClickHandler h = new MapRightClickHandler() {

          public void onRightClick(MapRightClickEvent e) {
            textBox.setText(textBox.getText() + "onRightClick(" + e.getPoint()
                + ")");
          }
        };
        map.addMapRightClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapRightClickHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_TYPE_CHANGED_HANDLER: {
        final MapTypeChangedHandler h = new MapTypeChangedHandler() {

          public void onTypeChanged(MapTypeChangedEvent e) {
            textBox.setText(textBox.getText() + "onTypeChanged()");
          }
        };
        map.addMapTypeChangedHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapTypeChangedHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;

      case MAP_ZOOM_END_HANDLER: {
        final MapZoomEndHandler h = new MapZoomEndHandler() {

          public void onZoomEnd(MapZoomEndEvent e) {
            textBox.setText(textBox.getText() + "onZoomEnd("
                + e.getNewZoomLevel() + "," + e.getOldZoomLevel() + ")");
          }
        };
        map.addMapZoomEndHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            map.removeMapZoomEndHandler(h);
            // removeRowFromTable(nextListenerId);
          }
        });
      }
        break;
      case MARKER_CLICK_HANDLER: {

        final MarkerClickHandler h = new MarkerClickHandler() {

          public void onClick(MarkerClickEvent e) {
            textBox.setText(textBox.getText() + "onClick()");
          }
        };
        marker.addMarkerClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerClickHandler(h);
          }
        });
      }
        break;
      case MARKER_DOUBLE_CLICK_HANDLER: {

        final MarkerDoubleClickHandler h = new MarkerDoubleClickHandler() {

          public void onDoubleClick(MarkerDoubleClickEvent e) {
            textBox.setText(textBox.getText() + "onDoubleClick()");
          }
        };
        marker.addMarkerDoubleClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerDoubleClickHandler(h);
          }
        });
      }
        break;
      case MARKER_MOUSE_DOWN_HANDLER: {

        final MarkerMouseDownHandler h = new MarkerMouseDownHandler() {

          public void onMouseDown(MarkerMouseDownEvent e) {
            textBox.setText(textBox.getText() + "onMouseDown()");
          }
        };
        marker.addMarkerMouseDownHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerMouseDownHandler(h);
          }
        });
      }
        break;
      case MARKER_MOUSE_UP_HANDLER: {

        final MarkerMouseUpHandler h = new MarkerMouseUpHandler() {

          public void onMouseUp(MarkerMouseUpEvent e) {
            textBox.setText(textBox.getText() + "onMouseUp()");
          }
        };
        marker.addMarkerMouseUpHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerMouseUpHandler(h);
          }
        });
      }
        break;
      case MARKER_MOUSE_OVER_HANDLER: {

        final MarkerMouseOverHandler h = new MarkerMouseOverHandler() {

          public void onMouseOver(MarkerMouseOverEvent e) {
            textBox.setText(textBox.getText() + "onMouseOver()");
          }
        };
        marker.addMarkerMouseOverHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerMouseOverHandler(h);
          }
        });
      }
        break;
      case MARKER_MOUSE_OUT_HANDLER: {

        final MarkerMouseOutHandler h = new MarkerMouseOutHandler() {

          public void onMouseOut(MarkerMouseOutEvent e) {
            textBox.setText(textBox.getText() + "onMouseOut()");
          }
        };
        marker.addMarkerMouseOutHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerMouseOutHandler(h);
          }
        });
      }
        break;
      case MARKER_INFO_WINDOW_OPEN_HANDLER: {

        final MarkerInfoWindowOpenHandler h = new MarkerInfoWindowOpenHandler() {

          public void onInfoWindowOpen(MarkerInfoWindowOpenEvent e) {
            textBox.setText(textBox.getText() + "onInfoWindowOpen()");
          }
        };
        marker.addMarkerInfoWindowOpenHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerInfoWindowOpenHandler(h);
          }
        });
      }
        break;
      case MARKER_INFO_WINDOW_BEFORECLOSE_HANDLER: {

        final MarkerInfoWindowBeforeCloseHandler h = new MarkerInfoWindowBeforeCloseHandler() {

          public void onInfoWindowBeforeClose(MarkerInfoWindowBeforeCloseEvent e) {
            textBox.setText(textBox.getText() + "onInfoWindowBeforeClose()");
          }
        };
        marker.addMarkerInfoWindowBeforeCloseHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerInfoWindowBeforeCloseHandler(h);
          }
        });
      }
        break;
      case MARKER_INFO_WINDOW_CLOSE_HANDLER: {

        final MarkerInfoWindowCloseHandler h = new MarkerInfoWindowCloseHandler() {

          public void onInfoWindowClose(MarkerInfoWindowCloseEvent e) {
            textBox.setText(textBox.getText() + "onInfoWindowClose()");
          }
        };
        marker.addMarkerInfoWindowCloseHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerInfoWindowCloseHandler(h);
          }
        });
      }
        break;
      case MARKER_REMOVE_HANDLER: {

        final MarkerRemoveHandler h = new MarkerRemoveHandler() {

          public void onRemove(MarkerRemoveEvent e) {
            textBox.setText(textBox.getText() + "onRemove()");
          }
        };
        marker.addMarkerRemoveHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerRemoveHandler(h);
          }
        });
      }
        break;
      case MARKER_DRAG_START_HANDLER: {

        final MarkerDragStartHandler h = new MarkerDragStartHandler() {

          public void onDragStart(MarkerDragStartEvent e) {
            textBox.setText(textBox.getText() + "onDragStart()");
          }
        };
        marker.addMarkerDragStartHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerDragStartHandler(h);
          }
        });
      }
        break;
      case MARKER_DRAG_HANDLER: {

        final MarkerDragHandler h = new MarkerDragHandler() {

          public void onDrag(MarkerDragEvent e) {
            textBox.setText(textBox.getText() + "onDrag()");
          }
        };
        marker.addMarkerDragHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerDragHandler(h);
          }
        });
      }
        break;
      case MARKER_DRAG_END_HANDLER: {

        final MarkerDragEndHandler h = new MarkerDragEndHandler() {

          public void onDragEnd(MarkerDragEndEvent e) {
            textBox.setText(textBox.getText() + "onDragEnd()");
          }
        };
        marker.addMarkerDragEndHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerDragEndHandler(h);
          }
        });
      }
        break;
      case MARKER_VISIBILITY_CHANGED_HANDLER: {

        final MarkerVisibilityChangedHandler h = new MarkerVisibilityChangedHandler() {

          public void onVisibilityChanged(MarkerVisibilityChangedEvent e) {
            textBox.setText(textBox.getText() + "onVisibilityChanged("
                + e.isVisible() + ")");
          }
        };
        marker.addMarkerVisibilityChangedHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {
          public void onClick(Widget sender) {
            marker.removeMarkerVisibilityChangedHandler(h);
          }
        });
      }
        break;

      case POLYLINE_CLICK_HANDLER: {

        final PolylineClickHandler h = new PolylineClickHandler() {

          public void onClick(PolylineClickEvent e) {
            textBox.setText(textBox.getText() + "onClick(" + e.getLatLng()
                + ")");
          }

        };
        polyline.addPolylineClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            polyline.removePolylineClickHandler(h);
          }

        });
      }
        break;

      case POLYLINE_REMOVE_HANDLER: {

        final PolylineRemoveHandler h = new PolylineRemoveHandler() {

          public void onRemove(PolylineRemoveEvent e) {
            textBox.setText(textBox.getText() + "onRemove()");
          }

        };
        polyline.addPolylineRemoveHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            polyline.removePolylineRemoveHandler(h);
          }

        });
      }
        break;

      case POLYLINE_VISIBILITY_CHANGED_HANDLER: {

        final PolylineVisibilityChangedHandler h = new PolylineVisibilityChangedHandler() {

          public void onVisibilityChanged(PolylineVisibilityChangedEvent e) {
            textBox.setText(textBox.getText() + "onVisibilityChanged("
                + e.isVisible() + ")");
          }

        };
        polyline.addPolylineVisibilityChangedHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            polyline.removePolylineVisibilityChangedHandler(h);
          }

        });
      }
        break;

      case POLYGON_CLICK_HANDLER: {

        final PolygonClickHandler h = new PolygonClickHandler() {

          public void onClick(PolygonClickEvent e) {
            textBox.setText(textBox.getText() + "onClick(" + e.getLatLng()
                + ")");
          }

        };
        polygon.addPolygonClickHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            polygon.removePolygonClickHandler(h);
          }

        });
      }
        break;

      case POLYGON_REMOVE_HANDLER: {

        final PolygonRemoveHandler h = new PolygonRemoveHandler() {

          public void onRemove(PolygonRemoveEvent e) {
            textBox.setText(textBox.getText() + "onRemove()");
          }

        };
        polygon.addPolygonRemoveHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            polygon.removePolygonRemoveHandler(h);
          }

        });
      }
        break;

      case POLYGON_VISIBILITY_CHANGED_HANDLER: {

        final PolygonVisibilityChangedHandler h = new PolygonVisibilityChangedHandler() {

          public void onVisibilityChanged(PolygonVisibilityChangedEvent e) {
            textBox.setText(textBox.getText() + "onVisibilityChanged("
                + e.isVisible() + ")");
          }

        };
        polygon.addPolygonVisibilityChangedHandler(h);
        removeHandlerButton.addClickListener(new ClickListener() {

          public void onClick(Widget sender) {
            polygon.removePolygonVisibilityChangedHandler(h);
          }

        });
      }
        break;

      default:
        Window.alert("Unhandled HandlerActions case : " + a.valueOf());
    }
  }

  private void clearListenerTable() {
    int numRows = handlerTable.getRowCount();
    for (int i = numRows - 1; i >= 0; i--) {
      handlerTable.removeRow(i);
    }

    handlerTable.setHTML(0, 0, "<b>ID</b>");
    handlerTable.setHTML(0, 1, "<b>Type</b>");
    handlerTable.setHTML(0, 2, "<b>Events</b>");
    handlerTable.setHTML(0, 3, "<b>Clear Text</b>");
    handlerTable.setHTML(0, 4, "<b>Remove Listener</b>");
  }

  private void computeAtlantaTriangle() {
    LatLngBounds bounds = map.getBounds();
    LatLng center = map.getCenter();
    LatLng ne = bounds.getNorthEast();
    LatLng sw = bounds.getSouthWest();
    GWT.log("ne=" + ne + ", sw=" + sw, null);
    double vertDelta = ne.getLatitude() - sw.getLatitude();
    double horizDelta = ne.getLongitude() - sw.getLongitude();
    double vertGrid = vertDelta / 4.0;
    double horizGrid = horizDelta / 8.0;

    // A triangle pointing north to the west of the center of the map.
    ATLANTA_TRIANGLE1[0] = new LatLng(center.getLatitude() + vertGrid,
        center.getLongitude() - 2 * horizGrid);
    ATLANTA_TRIANGLE1[1] = new LatLng(center.getLatitude() - vertGrid,
        center.getLongitude() - 3 * horizGrid);
    ATLANTA_TRIANGLE1[2] = new LatLng(center.getLatitude() - vertGrid,
        center.getLongitude() - horizGrid);
    ATLANTA_TRIANGLE1[3] = ATLANTA_TRIANGLE1[0];

    GWT.log("1[0] = " + ATLANTA_TRIANGLE1[0], null);
    GWT.log("1[1] = " + ATLANTA_TRIANGLE1[1], null);
    GWT.log("1[2] = " + ATLANTA_TRIANGLE1[2], null);
    GWT.log("1[3] = " + ATLANTA_TRIANGLE1[3], null);

    // A triangle pointing south to the east of the center of the map.
    ATLANTA_TRIANGLE2[0] = new LatLng(center.getLatitude() - vertGrid,
        center.getLongitude() + 2 * horizGrid);
    ATLANTA_TRIANGLE2[1] = new LatLng(center.getLatitude() + vertGrid,
        center.getLongitude() + 3 * horizGrid);
    ATLANTA_TRIANGLE2[2] = new LatLng(center.getLatitude() + vertGrid,
        center.getLongitude() + horizGrid);
    ATLANTA_TRIANGLE2[3] = ATLANTA_TRIANGLE2[0];

    GWT.log("2[0] = " + ATLANTA_TRIANGLE2[0], null);
    GWT.log("2[1] = " + ATLANTA_TRIANGLE2[1], null);
    GWT.log("2[2] = " + ATLANTA_TRIANGLE2[2], null);
    GWT.log("2[3] = " + ATLANTA_TRIANGLE2[3], null);
  }

  /**
   * Create a panel of buttons to use to perform various actions on the marker.
   */
  private Panel createActionButtons() {
    VerticalPanel vp = new VerticalPanel();
    HorizontalPanel hp = new HorizontalPanel();
    hp.setSpacing(10);

    vp.add(hp);

    // Create a button to hide/show the marker
    final Button hideButton = new Button("Hide Marker");
    hideButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        boolean state = !marker.isVisible();
        marker.setVisible(state);
        if (state) {
          hideButton.setText("Hide Marker");
        } else {
          hideButton.setText("Show Marker");
        }
      }
    });
    hp.add(hideButton);

    // Create a button to remove the marker from the map.
    final Button removeButton = new Button("Remove Marker");
    removeButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        if (!markerRemoved) {
          map.removeOverlay(marker);
          removeButton.setText("Add Marker");
        } else {
          map.addOverlay(marker);
          removeButton.setText("Remove Marker");
        }
        hideButton.setEnabled(markerRemoved);
        markerRemoved = !markerRemoved;
      }
    });
    hp.add(removeButton);

    // Create a button to hide/show the polygon
    final Button hidePolygonButton = new Button("Hide Polygon");
    hidePolygonButton.setEnabled(false);
    hidePolygonButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        boolean state = !polygon.isVisible();
        polygon.setVisible(state);
        if (state) {
          hidePolygonButton.setText("Hide Polygon");
        } else {
          hidePolygonButton.setText("Show Polygon");
        }
      }
    });
    hp.add(hidePolygonButton);

    // Create a button to remove the polygon from the map.
    final Button removePolygonButton = new Button("Add Polygon");
    removePolygonButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        if (!polygonRemoved) {
          map.removeOverlay(polygon);
          removePolygonButton.setText("Add Polygon");
        } else {
          map.addOverlay(polygon);
          removePolygonButton.setText("Remove Polygon");
        }
        hidePolygonButton.setEnabled(polygonRemoved);
        polygonRemoved = !polygonRemoved;
      }
    });
    hp.add(removePolygonButton);

    // Create a button to hide/show the polyline
    final Button hidePolylineButton = new Button("Hide Polyline");
    hidePolylineButton.setEnabled(false);
    hidePolylineButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        boolean state = !polyline.isVisible();
        polyline.setVisible(state);
        if (state) {
          hidePolylineButton.setText("Hide Polyline");
        } else {
          hidePolylineButton.setText("Show Polyline");
        }
      }
    });
    hp.add(hidePolylineButton);

    // Create a button to remove the polyline from the map.
    final Button removePolylineButton = new Button("Add Polyline");
    removePolylineButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        if (!polylineRemoved) {
          map.removeOverlay(polyline);
          removePolylineButton.setText("Add Polyline");
        } else {
          map.addOverlay(polyline);
          removePolylineButton.setText("Remove Polyline");
        }
        hidePolylineButton.setEnabled(polylineRemoved);
        polylineRemoved = !polylineRemoved;
      }
    });
    hp.add(removePolylineButton);

    final Button clearOverlaysButton = new Button("Clear Overlays");
    clearOverlaysButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        map.clearOverlays();
      }
    });

    hp.add(clearOverlaysButton);

    hp = new HorizontalPanel();
    hp.setSpacing(10);
    vp.add(hp);

    final Button infoWindowButton = new Button("Show InfoWindow");
    infoWindowButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        InfoWindow info = map.getInfoWindow();
        InfoWindowContent content = new InfoWindowContent("Hello Maps!");
        content.setMaxContent("Hello Maps - more content");
        content.setMaxTitle("Hello Maps");
        info.open(map.getCenter(), content);
      }
    });
    hp.add(infoWindowButton);

    final Button mInfoWindowButton = new Button("Marker InfoWindow");
    mInfoWindowButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        InfoWindow info = map.getInfoWindow();
        InfoWindowContent content = new InfoWindowContent("Hello Maps!");
        content.setMaxContent("Hello Maps - more content");
        content.setMaxTitle("Hello Maps");
        info.open(marker, content);
      }
    });
    hp.add(mInfoWindowButton);

    final Button mapTypeButton = new Button("Add Map Type");
    mapTypeButton.addClickListener(new ClickListener() {

      public void onClick(Widget sender) {
        if (!mapTypeRemoved) {
          map.addMapType(MapType.getSkyVisibleMap());
          mapTypeButton.setText("Remove MapType");
        } else {
          map.removeMapType(MapType.getSkyVisibleMap());
          mapTypeButton.setText("Add MapType");
        }
        mapTypeRemoved = !mapTypeRemoved;
      }

    });
    hp.add(mapTypeButton);

    // Create a button to clear out the table.
    final Button clearTableButton = new Button("Clear Table");
    clearTableButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        clearListenerTable();
      }
    });
    hp.add(clearTableButton);

    return vp;
  }

  /**
   * Create a drop down list that shows all the different types of listeners
   * that can be added.
   * 
   * @return a ListBox populated with the ListenerActions values
   */
  private HorizontalPanel createListenerListBox() {
    HorizontalPanel h = new HorizontalPanel();

    final ListBox listenerBox = new ListBox();
    for (HandlerActions a : HandlerActions.values()) {
      listenerBox.addItem(a.valueOf());
    }
    h.add(listenerBox);

    Button b = new Button("Add Handler");
    b.addClickListener(new ClickListener() {

      public void onClick(Widget sender) {
        int selectedIndex = listenerBox.getSelectedIndex();
        HandlerActions a = HandlerActions.values()[selectedIndex];
        addListenerToMarker(a);
      }

    });
    h.add(b);

    return h;
  }
}