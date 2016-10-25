var nodeIdCounter = -1; // use a sequence to guarantee key uniqueness as we add/remove/modify nodes

// alert("chart loaded1111");
var $ = go.GraphObject.make;  // for conciseness in defining templates
var model = $(go.TreeModel);
model.nodeDataArray =
    [
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/09/PaikopoulosThumb.jpg",
            url: "www.paikopoulos.gr/istoria",
            key: "19",
            name: "Παϊκόπουλος Γιώργος",
            title: "Διευθυντής Γραφείου",
            parent: "1",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/09/PaikopoulosThumb.jpg",
            url: "www.paikopoulos.gr/istoria",
            key: "1",
            name: "Παϊκόπουλος Γιώργος",
            title: "Συντονιστής Επιθεωρητής Πωλήσεων",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/ntaraklitsi-1-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/ntaraklitsi-eleni",
            key: "2",
            name: "Νταρακλήτση Ελένη",
            title: "Αναπληρώτρια Διευθύντρια",
            parent: "19",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/georgopoulos-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/georgopoulos-dimitrios/",
            key: "3",
            name: "Γεωργόπουλος Δημήτρης",
            title: "Διευθυντής Ομάδας",
            parent: "2",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/10/tzinhs-1.jpg",
            url: "www.paikopoulos.gr/synergates/tzinis-nikolaos/",
            key: "4",
            name: "Τζίνης Νικόλαος",
            title: "Διευθυντής Ομάδας",
            parent: "3",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/09/Ζάχαρης-Ανδρέας1-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/zacharis-andreas/",
            key: "5",
            name: "Ζάχαρης Ανδρέας",
            title: "Διευθυντής Ομάδας",
            parent: "4",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/gnet-4-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/varela-eleni",
            key: "6",
            name: "Βαρελά Ελένη",
            title: "Διευθύντρια Ομάδας",
            parent: "5",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/1-1-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/karampalis-michalis/",
            key: "9",
            name: "Καλαμπαλής Μιχάλης",
            title: "Διευθυντής Ομάδας",
            parent: "18",
            visible:true
        }, {
            pic: "",
            url: "http://www.paikopoulos.gr",
            key: "18",
            name: "",
            title: "",
            parent: "19",
            visible:null
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/petroxeilos.jpg",
            url: "www.paikopoulos.gr/synergates/petrochilos-emmanouil",
            key: "10",
            name: "Πετρόχειλος Μανώλης",
            title: "Διευθυντής Ομάδας",
            parent: "9",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/papadopoulos-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/papadopoulos-nikos/",
            key: "11",
            name: "Παπαδόπουλος Νίκος",
            title: "Διευθυντής Ομάδας",
            parent: "10",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2015/10/20151221_183352-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/koutzamanis-georgios",
            key: "12",
            name: "Κουτζαμάνης Γεώργιος",
            title: "Διευθυντής Γραφείου",
            parent: "1",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/moumtzis-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/moutzis-stilianos/",
            key: "13",
            name: "Μουμτζής Στέλιος",
            title: "Αναπληρωτής Διευθυντής",
            parent: "12",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/10/Βαρδαξόγλου-Αντώνης.jpg",
            url: "http://www.paikopoulos.gr/synergates/vardaxoglou-antonis/",
            key: "14",
            name: "Βαρδαξόγλου Αντώνης",
            title: "Διευθυντής Ομάδας",
            parent: "13",
            visible:true
        },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2015/10/photo-1-260x260.jpg",
            url: "www.paikopoulos.gr/synergates/xalkodaimon-panagiotis",
            key: "15",
            name: "Χαλκοδαίμων Παναγιώτης",
            title: "Διευθυντής Γραφείου",
            parent: "1",
            visible:true
        },
        {
            pic: "",
            url: "http://www.paikopoulos.gr",
            key: "20",
            name: "",
            title: "",
            parent: "15",
            visible:null
        }, {
        pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/04/gnet-2-260x260.jpg",
        url: "www.paikopoulos.gr/synergates/lardis-iordanis/",
        key: "16",
        name: "Λαρδής Ιορδάνης",
        title: "Διευθυντής Ομάδας",
        parent: "20",
        visible:true
    },
        {
            pic: "http://www.paikopoulos.gr/wp-content/uploads/2016/10/lamprou_lefteris.jpg",
            url: "http://www.paikopoulos.gr/synergates/lamprou-lefteris/",
            key: "17",
            name: "Λάμπρου Λευτέρης",
            title: "Διευθυντής Ομάδας",
            parent: "16",
            visible:true
        }
    ];

    myDiagram =
    $(go.Diagram, "paikopoulosDiv", // must be the ID or reference to div
        {
            initialContentAlignment: go.Spot.Center,
            maxSelectionCount: 1, // users can select only one part at a time
            validCycle: go.Diagram.CycleDestinationTree, // make sure users can only create trees
//                            "clickCreatingTool.archetypeNodeData": {}, // allow double-click in background to create a new node
//                            "clickCreatingTool.insertPart": function(loc) {  // customize the data for the new node
//                                this.archetypeNodeData = {
//                                    key: getNextKey(), // assign the key based on the number of nodes
//                                    name: "(new person)",
//                                    title: ""
//                                };
//                                return go.ClickCreatingTool.prototype.insertPart.call(this, loc);
//                            },
            layout: $(go.TreeLayout,
                {
                    treeStyle: go.TreeLayout.StyleLastParents,
                    arrangement: go.TreeLayout.ArrangementFixedRoots,
                    // properties for most of the tree:
                    angle: 90,
                    layerSpacing: 35,
                    // properties for the "last parents":
                    alternateAngle: 90,
                    alternateLayerSpacing: 35,
                    alternateAlignment: go.TreeLayout.AlignmentBus,
                    alternateNodeSpacing: 20
                }),
            "undoManager.isEnabled": true // enable undo & redo
        });
myDiagram.model = model;
var levelColors = ["#00529C/#00529C", "#E72331/#E72331", "#8C0095/#A700AE", "#D24726/#DC572E",
    "#D24726/#DC572E", "#D24726/#DC572E", "#D24726/#DC572E", "#D24726/#DC572E"];
//            "#008299/#00A0B1", "#D24726/#DC572E", "#008A00/#00A600", "#094AB2/#0A5BC4"];
// override TreeLayout.commitNodes to also modify the background brush based on the tree depth level
myDiagram.layout.commitNodes = function () {
    go.TreeLayout.prototype.commitNodes.call(myDiagram.layout);  // do the standard behavior
    // then go through all of the vertexes and set their corresponding node's Shape.fill
    // to a brush dependent on the TreeVertex.level value
    myDiagram.layout.network.vertexes.each(function (v) {
        if (v.node) {
            var level = v.level % (levelColors.length);
            var colors = levelColors[level].split("/");
            var shape = v.node.findObject("SHAPE");
            if (shape) shape.fill = $(go.Brush, "Linear", {
                0: colors[0],
                1: colors[1],
                start: go.Spot.Left,
                end: go.Spot.Right
            });
        }
    });
};

//this function reads the url param and redirects to the url link of the object
function nodeClick(e, obj) {
    var clicked = obj.part;
    if (clicked !== null) {
        window.location.href = "http://" + clicked.data.url;
    }
}

// this is used to determine feedback during drags
function mayWorkFor(node1, node2) {
    if (!(node1 instanceof go.Node)) return false;  // must be a Node
    if (node1 === node2) return false;  // cannot work for yourself
    if (node2.isInTreeOf(node1)) return false;  // cannot work for someone who works for you
    return true;
}

// This function provides a common style for most of the TextBlocks.
// Some of these values may be overridden in a particular TextBlock.
function textStyle() {
    return {font: "9pt  Segoe UI,sans-serif", stroke: "white"};
}

//        // This converter is used by the Picture.
//        function findHeadShot(obj) {
//            var clicked = obj.part;
//            if (clicked!==null) {
//                return clicked.data.picture;
//            }
////            if (key < 0 || key > 16) return "images/HSnopic.png"; // There are only 16 images on the server
////            return "images/HS" + key + ".png"
//            return "cat1.png";
//        }

// define the Node template
myDiagram.nodeTemplate =
    $(go.Node, "Auto",
        {click: nodeClick},
        { // handle dragging a Node onto a Node to (maybe) change the reporting relationship
            mouseDragEnter: function (e, node, prev) {
                var diagram = node.diagram;
                var selnode = diagram.selection.first();
                if (!mayWorkFor(selnode, node)) return;
                var shape = node.findObject("SHAPE");
                if (shape) {
                    shape._prevFill = shape.fill;  // remember the original brush
                    shape.fill = "darkred";
                }
            },
            mouseDragLeave: function (e, node, next) {
                var shape = node.findObject("SHAPE");
                if (shape && shape._prevFill) {
                    shape.fill = shape._prevFill;  // restore the original brush
                }
            },
            mouseDrop: function (e, node) {
                var diagram = node.diagram;
                var selnode = diagram.selection.first();  // assume just one Node in selection
                if (mayWorkFor(selnode, node)) {
                    // find any existing link into the selected node
                    var link = selnode.findTreeParentLink();
                    if (link !== null) {  // reconnect any existing link
                        link.fromNode = node;
                    } else {  // else create a new link
                        diagram.toolManager.linkingTool.insertLink(node, node.port, selnode, selnode.port);
                    }
                }
            }
        },
        // for sorting, have the Node.text be the data.name
        new go.Binding("text", "name"),
        new go.Binding("layerName", "isSelected", function (sel) {
            return sel ? "Foreground" : "";
        }).ofObject(),
        // define the node's outer shape
        $(go.Shape, "Rectangle",
            {
                name: "SHAPE", fill: "white", stroke: null,
                // set the port properties:
                portId: "", fromLinkable: true, toLinkable: true, cursor: "pointer"
            }

            //new go.Binding("opacity", "visible", function(t) { return t ? 1 : 0; })
            // new go.Binding("visible", "visible", function(t) { return t ? true : false; })
        ),
        $(go.Panel, "Horizontal",
            $(go.Picture,
                {
                    name: 'Picture',
                    desiredSize: new go.Size(80, 83),
                    margin: new go.Margin(6, 8, 6, 10),
                },
                new go.Binding("source", "pic")),
            // define the panel where the text will appear
            $(go.Panel, "Table",
                {
                    maxSize: new go.Size(150, 999),
                    margin: new go.Margin(6, 10, 0, 3),
                    defaultAlignment: go.Spot.Left
                },
                $(go.RowColumnDefinition, {column: 2, width: 4}),
                $(go.TextBlock, textStyle(),  // the name
                    {
                        row: 0, column: 0, columnSpan: 5,
                        font: "12pt Segoe UI,sans-serif",
                        editable: true, isMultiline: false,
                        minSize: new go.Size(10, 16)
                    },
                    new go.Binding("text", "name").makeTwoWay()),
//                                        $(go.TextBlock, "", textStyle(),
//                                                {row: 1, column: 0}),
                $(go.TextBlock, textStyle(),
                    {
                        row: 1, column: 1, columnSpan: 4,
                        editable: true, isMultiline: false,
                        minSize: new go.Size(10, 14),
                        margin: new go.Margin(0, 0, 0, 3)
                    },
                    new go.Binding("text", "title").makeTwoWay()),
//                                        $(go.TextBlock, textStyle(),
//                                                {row: 2, column: 0},
//                                                new go.Binding("text", "key", function (v) {
//                                                    return "ID: " + v;
//                                                })),
//                                        $(go.TextBlock, textStyle(),
//                                                {name: "boss", row: 2, column: 3,}, // we include a name so we can access this TextBlock when deleting Nodes/Links
//                                                new go.Binding("text", "parent", function (v) {
//                                                    return "Boss: " + v;
//                                                })),
                $(go.TextBlock, textStyle(),  // the comments
                    {
                        row: 3, column: 0, columnSpan: 5,
                        font: "italic 9pt sans-serif",
                        wrap: go.TextBlock.WrapFit,
                        editable: true,  // by default newlines are allowed
                        minSize: new go.Size(10, 14)
                    },
                    new go.Binding("text", "comments").makeTwoWay())
            )  // end Table Panel
        ) // end Horizontal Panel
    );  // end Node
// the context menu allows users to make a position vacant,
// remove a role and reassign the subtree, or remove a department
// define the Link template
myDiagram.linkTemplate =
    $(go.Link, go.Link.Orthogonal,
        {corner: 5, relinkableFrom: true, relinkableTo: true},
        $(go.Shape, {strokeWidth: 4, stroke: "#00a4a4"}));  // the link shape
// read in the JSON-format data from the "mySavedModel" element
//        load();
// support editing the properties of the selected person in HTML
if (window.Inspector) myInspector = new Inspector('myInspector', myDiagram,
    {
        properties: {
            'key': {readOnly: true},
            'comments': {}
        }
    });
// Show the diagram's model in JSON format
//    function save() {
//        document.getElementById("mySavedModel").value = myDiagram.model.toJson();
//        myDiagram.isModified = false;
//    }